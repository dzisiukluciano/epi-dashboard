package com.epidataconsulting.metrics.common.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;


@ImportResource("classpath:businessProperties-config.xml")
public abstract class AbstractBusinessHibernateConfig {
	
	  private @Value("${jdbcBusiness.url}") String url;
	  private @Value("${jdbcBusiness.username}") String username;
	  private @Value("${jdbcBusiness.password}") String password;
	  private @Value("${jdbcBusiness.driverClassName}") String driverClassName;
	  private @Value("${hibernateBusiness.dialect}") String dialect;
	  private @Value("${hibernateBusiness.showSql}") String showSql;
	  private @Value("${hibernateBusiness.hbm2ddl.auto}") String hbm2ddlauto;

	  public @Bean DataSource dataSourceBusiness() {
		  BasicDataSource datasource = new BasicDataSource();
		  datasource.setUrl(url);
		  datasource.setPassword(password);
		  datasource.setUsername(username);
		  datasource.setDriverClassName(driverClassName);
		  
	      return datasource;
	  }
	  
	  @Bean public SessionFactory sessionFactoryBusiness() {
		  AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
		  
		  sessionFactory.setDataSource(dataSourceBusiness());
		  sessionFactory.setPackagesToScan(getPackagesToScan());
		  sessionFactory.setHibernateProperties(hibernatePropertiesBusiness());
		  try {
			sessionFactory.afterPropertiesSet();
		} catch (Exception e) {
			throw new BeanCreationException(e.getMessage());
		}
		  
		  return (SessionFactory) sessionFactory.getObject();
	  }
	  
	  protected abstract String [] getPackagesToScan();
	  
	  public @Bean Properties hibernatePropertiesBusiness(){
		  Properties hibernateProperties = new Properties();
		  
		  hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hbm2ddlauto);
		  hibernateProperties.setProperty("show_sql", showSql);
		  hibernateProperties.setProperty("hibernate.dialect", dialect);
		  //hibernateProperties.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
		  // hibernateProperties.setProperty("current_session_context_class", "thread");
		  
		  return hibernateProperties;
	  }

}
