package com.epidataconsulting.metrics.common.dao;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractBusinessDAO extends AbstractDomainDAO{
	
	@Autowired
	@Qualifier("sessionFactoryBusiness")
	private SessionFactory sessionFactory;
	
	@Autowired
	@Qualifier("dataSourceBusiness")
	private DataSource dataSource;
	
	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Override
	public DataSource getDataSource() {
		return dataSource;
	}
	
}
