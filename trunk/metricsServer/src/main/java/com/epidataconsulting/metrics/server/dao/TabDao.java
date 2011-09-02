package com.epidataconsulting.metrics.server.dao;

import org.springframework.stereotype.Repository;

import com.epidataconsulting.metrics.common.dao.AbstractDomainDAO;

@Repository
public class TabDao extends AbstractDomainDAO{	
	
	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		
		return TabDao.class;
	}

}
