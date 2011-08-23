package com.epidataconsulting.metrics.common.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.proxy.HibernateProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.epidataconsulting.metrics.common.domain.AbstractDomain;

public abstract class AbstractDomainDAO {
	
	private static Logger logger = LoggerFactory.getLogger(AbstractDomainDAO.class);
	
	@SuppressWarnings("rawtypes")
	public abstract Class getClazz(); 
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll () {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(getClazz());
		return (List<T>)criteria.list();
	}
	
	public void save(AbstractDomain object) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(object);
	}
	
	public void update(AbstractDomain object) {
		Session session = getSessionFactory().getCurrentSession();
		session.merge(object);
	}
	public void persist(AbstractDomain object) {
		Session session = getSessionFactory().getCurrentSession();
		session.persist(object);
	}
	public void saveOrUpdate(AbstractDomain object){
		Session session = getSessionFactory().getCurrentSession();
		session.saveOrUpdate(object);
	}
	
	/**
	 * Devuelve una entidad persistida 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public <T> T  load (Serializable id) {
		Session session = getSessionFactory().getCurrentSession();
		T result = null;
		try {
			result = (T) session.load(getClazz(), id);
			result = initializeAndUnproxy(result);
		} catch (HibernateException e) {
			logger.debug(e.getMessage());
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T initializeAndUnproxy(T entity) {
	    if (entity == null) {
	        throw new 
	           NullPointerException("La entidad pasada para inicializar es nula");
	    }

	    Hibernate.initialize(entity);
	    if (entity instanceof HibernateProxy) {
	        entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer()
	                .getImplementation();
	    }
	    return entity;
	}
	public void delete(AbstractDomain object){
		Session session = getSessionFactory().getCurrentSession();
		session.delete(object);
		
	}
}
