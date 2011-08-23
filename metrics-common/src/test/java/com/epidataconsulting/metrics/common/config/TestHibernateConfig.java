package com.epidataconsulting.metrics.common.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TestHibernateConfig extends AbstractHibernateConfig {

	@Override
	protected String[] getPackagesToScan() {
		String [] result = new String [] {
				"com.epidataconsulting.metrics.common.domain"
		};
		return result;
	}

}
