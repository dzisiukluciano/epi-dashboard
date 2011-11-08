package com.epidataconsulting.metrics.common.service;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;



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
