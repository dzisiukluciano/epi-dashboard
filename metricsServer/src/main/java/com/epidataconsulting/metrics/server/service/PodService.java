package com.epidataconsulting.metrics.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.epidataconsulting.metrics.server.dao.PodDao;
import com.epidataconsulting.metrics.server.dao.PodDataDao;
import com.epidataconsulting.metrics.server.dao.PodTypeDao;
import com.epidataconsulting.metrics.server.domain.Pod;
import com.epidataconsulting.metrics.server.domain.PodType;
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
			podDataDao.retrievePodData(pod.getDataSource(), pod.getCategoryField(), pod.getValueField());
		}catch (BadSqlGrammarException e) {
			throw new InvalidPodConfigurationException(e);
		}
			
		this.podDao.update(pod);
		return pod;
	}
	
}
