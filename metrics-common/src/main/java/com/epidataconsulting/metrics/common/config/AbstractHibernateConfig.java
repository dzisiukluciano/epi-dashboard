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


@ImportResource("classpath:properties-config.xml")
public abstract class AbstractHibernateConfig {
	
	  private @Value("${jdbc.url}") String url;
	  private @Value("${jdbc.username}") String username;
	  private @Value("${jdbc.password}") String password;
	  private @Value("${jdbc.driverClassName}") String driverClassName;
	  private @Value("${hibernate.dialect}") String dialect;
	  private @Value("${hibernate.showSql}") String showSql;
	  private @Value("${hibernate.hbm2ddl.auto}") String hbm2ddlauto;

	  public @Bean DataSource dataSource() {
		  BasicDataSource datasource = new BasicDataSource();
		  datasource.setUrl(url);
		  datasource.setPassword(password);
		  datasource.setUsername(username);
		  datasource.setDriverClassName(driverClassName);
		  
	      return datasource;
	  }
	  
	  @Bean public SessionFactory sessionFactory() {
		  AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
		  
		  sessionFactory.setDataSource(dataSource());
		  sessionFactory.setPackagesToScan(getPackagesToScan());
		  sessionFactory.setHibernateProperties(hibernateProperties());
		  try {
			sessionFactory.afterPropertiesSet();
		} catch (Exception e) {
			throw new BeanCreationException(e.getMessage());
		}
		  
		  return (SessionFactory) sessionFactory.getObject();
	  }
	  
	  protected abstract String [] getPackagesToScan();
	  
	  public @Bean Properties hibernateProperties(){
		  Properties hibernateProperties = new Properties();
		  
		  hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hbm2ddlauto);
		  hibernateProperties.setProperty("show_sql", showSql);
		  hibernateProperties.setProperty("hibernate.dialect", dialect);
		  //hibernateProperties.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
		  // hibernateProperties.setProperty("current_session_context_class", "thread");
		  
		  return hibernateProperties;
	  }

}
