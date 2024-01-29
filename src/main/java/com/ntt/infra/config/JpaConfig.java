package com.ntt.infra.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.ntt.infra.repository"})
@EnableTransactionManagement
public class JpaConfig {

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		
		LocalEntityManagerFactoryBean entityManagerFactory = new LocalEntityManagerFactoryBean();
		entityManagerFactory.setPersistenceUnitName("ServiceRequest"); 
		
		return entityManagerFactory;
		
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		
		return transactionManager; 
		
	}
	
}
