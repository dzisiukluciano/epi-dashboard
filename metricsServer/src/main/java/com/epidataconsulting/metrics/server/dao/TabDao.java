package com.epidataconsulting.metrics.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.epidataconsulting.metrics.common.dao.AbstractDomainDAO;
import com.epidataconsulting.metrics.server.domain.Tab;

@Repository
public class TabDao extends AbstractDomainDAO{	
	
	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		
		return Tab.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tab> findAll(){
		return this.findAllDistinct();
	}

}
