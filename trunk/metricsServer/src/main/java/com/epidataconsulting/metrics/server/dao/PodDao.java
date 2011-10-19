package com.epidataconsulting.metrics.server.dao;

import org.springframework.stereotype.Repository;

import com.epidataconsulting.metrics.common.dao.AbstractDomainDAO;
import com.epidataconsulting.metrics.server.domain.Pod;


@Repository
public class PodDao extends AbstractDomainDAO {

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Pod.class;
	}

}
