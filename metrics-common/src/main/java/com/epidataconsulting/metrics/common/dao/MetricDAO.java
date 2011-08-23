package com.epidataconsulting.metrics.common.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.epidataconsulting.metrics.common.domain.Indicator;
import com.epidataconsulting.metrics.common.domain.Metric;
@Repository
public class MetricDAO extends AbstractDomainDAO {

	@Override
	public Class getClazz() {
		// TODO Auto-generated method stub
		return Metric.class;
	}
	
	public Metric findByMetricaid(String metrica_id) {
		Metric result = null;
		try{
			Session session = getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Metric.class);
			criteria.add(Restrictions.eq("metricaID", metrica_id));
			
			result = (Metric) criteria.uniqueResult();
			
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
