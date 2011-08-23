package com.epidataconsulting.metrics.common;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epidataconsulting.metrics.common.service.MetricService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/application-context.xml")
public class MetricServiceTest {
	
	@Autowired
	private MetricService metricService;

	@Test
	public void findAll() {
		//List<Metric> metrics = metricService.findAll();
		
//		for (Iterator<Metric> iterator = metrics.iterator(); iterator.hasNext();) {
//			Metric metric = (Metric) iterator.next();
//			
//			System.out.println("Metric id:" + metric.getId());
//			
//		}
	}
	
	@Test
	public void save() {
		/*
		Metric metric = new Metric();
	
		metric.setName("mPrueba");
		
		metricService.save(metric);
		
	Assert.assertNotNull(metric.getId());
	*/
		}
}
