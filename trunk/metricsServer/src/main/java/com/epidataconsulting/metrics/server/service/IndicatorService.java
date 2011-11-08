package com.epidataconsulting.metrics.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epidataconsulting.metrics.common.dao.IndicatorDAO;
import com.epidataconsulting.metrics.common.domain.IndicatorDto;

@Service 
@RemotingDestination("indicatorService")
public class IndicatorService {
	
	@Autowired
	private IndicatorDAO indicatorDao;

	

	@Transactional
	public List<IndicatorDto> searchIndicator(String indicatorTable, String indicatorCode, String valueField, String scaleTable) throws Exception{
		try{
			List<IndicatorDto> indicators = indicatorDao.searchIndicator(indicatorTable,indicatorCode,valueField,scaleTable);
			for(IndicatorDto i : indicators){
				i.getIndicatorscale().calcularValores();
			}
			return indicators;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}
	
	
/*	
	@Transactional
	public List<Indicator> findAllIndicators() {
		List<Indicator> indicadores= indicatorDao.findAll();
		for (Indicator indicador : indicadores){
			if(indicador.getIndicatorscale() != null){
				indicador.getIndicatorscale().calcularValores();
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
*/
}
