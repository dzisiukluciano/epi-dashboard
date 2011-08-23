package com.epidataconsulting.metrics.server.service;

import java.io.IOException;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import flex.messaging.io.amf.ASObject; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epidataconsulting.metrics.common.dao.IndicatorDAO;
import com.epidataconsulting.metrics.common.dao.IndicatorScaleDAO;
import com.epidataconsulting.metrics.common.domain.Indicator;
import com.epidataconsulting.metrics.common.domain.IndicatorScale;

@Service 
@RemotingDestination("indicatorService")
public class IndicatorService {
	
	@Autowired
	private IndicatorDAO indicatorDao;
	@Autowired
	private IndicatorScaleDAO indicatorScaleDao;
	@Transactional
	public List<Indicator> findAllIndicators() {
		List<Indicator> indicadores= indicatorDao.findAll();
		for (Indicator indicador : indicadores){
			try{	
				indicador.evaluateQuality();
				indicador.getIndicatorscale().calcularValorPossionesIntermedias();
				indicador.getIndicatorscale().redondiarValores();
			}catch (Exception e) {
				//TODO lucianod: loggear u otra cosa, pero no println
				System.out.println("no posee su escala");
			}
		}
		return indicadores;
	}

	
	
	@Transactional
	public Indicator getIndicatorByCode(String code){
		return indicatorDao.findByCode(code);
	}
	
	@Transactional
	public IndicatorScale getIndicatorScale(int id){
		
		return indicatorScaleDao.load(id);
	}
	@Transactional
	public IndicatorScale getIndicatorScale(String code){
		IndicatorScale indicatorScale=indicatorScaleDao.findByCode(code);
		if(indicatorScale.getMaximo()< indicatorScale.getMinimo()){
			indicatorScale.setReverse(true);
		}
		return indicatorScale;
	}
	
	@Transactional
	public  Boolean updateIndicatorS(ASObject newscale) {
		IndicatorScale scale= new IndicatorScale();
		scale.setId((Integer) newscale.get("id"));
		scale.setCode((String) newscale.get("code"));
		scale.setMaximo((Integer) newscale.get("maximo"));
		scale.setBueno((Integer) newscale.get("bueno"));
		scale.setRegular((Integer) (newscale.get("regular")));
		scale.setMinimo((Integer) newscale.get("minimo"));
		
		indicatorScaleDao.update(scale);
		return true;
	}

}
