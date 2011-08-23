package com.epidataconsulting.metrics.common.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.epidataconsulting.metrics.common.dao.AbstractDomainDAO;
import com.epidataconsulting.metrics.common.domain.IndicatorScale;

@Repository
public class IndicatorScaleDAO  extends AbstractDomainDAO{

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		// TODO Auto-generated method stub
		return IndicatorScale.class;
	}
	
	public IndicatorScale findByCode(String code) {
		IndicatorScale result = null;
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IndicatorScale.class);
		criteria.add(Restrictions.eq("code", code));
		
		result = (IndicatorScale) criteria.uniqueResult();
		
		return result;
	}

}
