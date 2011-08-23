package com.epidataconsulting.metrics.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RemotingDestination(value="metricService")
public class MetricService {
/*	
	@Autowired
	private MetricDAO metricDAO;
	
	public MetricDAO getMetricDAO() {
		return metricDAO;
	}

	@Transactional
	public List<Metric> findAll(){
		
		return metricDAO.findAll();
	}
	
	@Transactional
	public void save(Metric metric){
		
		metricDAO.save(metric);
	}
*/
}
