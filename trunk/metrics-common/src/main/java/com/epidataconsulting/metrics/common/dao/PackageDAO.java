package com.epidataconsulting.metrics.common.dao;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.epidataconsulting.metrics.common.domain.AbstractDomain;
import com.epidataconsulting.metrics.common.domain.Indicator;
import com.epidataconsulting.metrics.common.domain.Package;
@Repository
public class PackageDAO extends AbstractDomainDAO {

	@Override
	public Class getClazz() {
		// TODO Auto-generated method stub
		return Package.class;
	}

	@SuppressWarnings("unchecked")
	public  List<Package>  findAllByParent(long parentID) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Package.class);
		criteria.add(Restrictions.eq("parentID", parentID));

		return (List<Package>)criteria.list();
	}
	public void deleteAll(){
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Package.class);
		Collection col = criteria.list();
		Iterator it = col.iterator();

		while( it.hasNext()) {
			Package packtmp = (Package) it.next();
		delete(packtmp);
		}
	}
}
