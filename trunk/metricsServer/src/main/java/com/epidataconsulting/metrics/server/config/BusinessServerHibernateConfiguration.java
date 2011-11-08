package com.epidataconsulting.metrics.server.config;

import org.springframework.context.annotation.Configuration;

import com.epidataconsulting.metrics.common.config.AbstractBusinessHibernateConfig;

@Configuration
public class BusinessServerHibernateConfiguration extends AbstractBusinessHibernateConfig {

	@Override
	protected String[] getPackagesToScan() {
		String [] result = new String []{};		
		return result;
		
//		String [] result = new String []{
//				"com.epidataconsulting.metrics.common.domain",
//				"com.epidataconsulting.metrics.server.domain"};
//			
//		return result;
	}

}
