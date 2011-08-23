package com.epidataconsulting.metrics.server.config;

import org.springframework.context.annotation.Configuration;

import com.epidataconsulting.metrics.common.config.AbstractHibernateConfig;

@Configuration
public class ServerHibernateConfiguration extends AbstractHibernateConfig {

	@Override
	protected String[] getPackagesToScan() {
		String [] result = new String []{
			"com.epidataconsulting.metrics.common.domain",
			"com.epidataconsulting.metrics.server.domain"};
		
		return result;
	}

}
