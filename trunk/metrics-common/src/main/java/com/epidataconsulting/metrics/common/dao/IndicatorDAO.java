package com.epidataconsulting.metrics.common.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.epidataconsulting.metrics.common.dao.AbstractDomainDAO;
import com.epidataconsulting.metrics.common.domain.Indicator;

@Repository
public class IndicatorDAO extends AbstractDomainDAO {

	@Override
	@SuppressWarnings("rawtypes")
	public Class getClazz() {
		return Indicator.class;
	}
	
	public Indicator findByCode(String code) {
		Indicator result = null;
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Indicator.class);
		criteria.add(Restrictions.eq("code", code));
		
		result = (Indicator) criteria.uniqueResult();
		
		return result;
	}

}
