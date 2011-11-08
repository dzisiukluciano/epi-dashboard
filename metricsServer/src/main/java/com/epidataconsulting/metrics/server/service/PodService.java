package com.epidataconsulting.metrics.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.epidataconsulting.metrics.common.dao.IndicatorDAO;
import com.epidataconsulting.metrics.common.domain.IndicatorDto;
import com.epidataconsulting.metrics.server.dao.PodDao;
import com.epidataconsulting.metrics.server.dao.PodDataDao;
import com.epidataconsulting.metrics.server.dao.PodTypeDao;
import com.epidataconsulting.metrics.server.domain.Pod;
import com.epidataconsulting.metrics.server.domain.PodType;
import com.epidataconsulting.metrics.server.domain.PodTypeName;
import com.epidataconsulting.metrics.server.domain.exception.InvalidPodConfigurationException;

@Service
@RemotingDestination("podService")
public class PodService {
	
	@Autowired
	private PodTypeDao podTypeDao; 
	
	@Autowired
	private PodDao podDao;
	
	@Autowired
	private PodDataDao podDataDao;
	
	@Autowired
	private IndicatorDAO indicatorDAO;
	
	@Transactional
	public List<PodType> retrievePodTypes(){
		return podTypeDao.findAll();
	}
	
	@Transactional
	public List<Pod> findAllPods(){
		return podDao.findAll();
	}
	
	@Transactional
	public Pod saveOrUpdatePod(Pod pod){		
		try{
			if(pod.getType().getName().equals(PodTypeName.Gauge)){
				//me fijo que encuentre datos con estos parámetros
				List<IndicatorDto> indicators = indicatorDAO.searchIndicator(pod.getDataSource(), pod.getCode(), pod.getValueField(), pod.getJoinTable());
				if(indicators == null || indicators.size() == 0){
					throw new InvalidPodConfigurationException(new Exception("No indicator was found with this code"));
				}
			}else{
				//me fijo que encuentre datos con estos parámetros
				podDataDao.retrievePodData(pod.getDataSource(), pod.getCategoryField(), pod.getValueField());				
			}
		}catch (BadSqlGrammarException e) {
			throw new InvalidPodConfigurationException(e);
		}
			
		this.podDao.update(pod);
		return pod;
	}
	
}
