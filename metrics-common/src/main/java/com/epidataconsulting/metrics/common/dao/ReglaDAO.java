package com.epidataconsulting.metrics.common.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.epidataconsulting.metrics.common.dao.AbstractDomainDAO;
import com.epidataconsulting.metrics.common.domain.Indicator;
import com.epidataconsulting.metrics.common.domain.Regla;

@Repository
public class ReglaDAO extends AbstractDomainDAO {

	@Override
	@SuppressWarnings("rawtypes")
	public Class getClazz() {
		return Regla.class;
	}
	public Regla findByCode(String code) {
		Regla result = null;
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Regla.class);
		criteria.add(Restrictions.eq("reglaid", code));
		
		result = (Regla) criteria.uniqueResult();
		
		return result;
	}


}
