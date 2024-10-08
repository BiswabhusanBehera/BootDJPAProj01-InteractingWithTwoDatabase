package com.nt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement	
@EnableJpaRepositories(basePackages = "com.nt.repository.prod",
											 entityManagerFactoryRef = "oraEMF",
											 transactionManagerRef = "oraTxMgmr")
public class OracleDBConfig {

	//DataSource obj
	@Bean("oraDs")
	@ConfigurationProperties(prefix = "ora.ds")
	@Primary
	public DataSource createOraDs() {
		return DataSourceBuilder.create().build();
	}
	
	//LocalContainerEntityManagerFactoryBean that give EntityManagerFactory object
	@Bean("oraEMF")
	@Primary
	public LocalContainerEntityManagerFactoryBean createLCEMFBForOracle(EntityManagerFactoryBuilder emBuilder) {
		//prepare HB properties
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		map.put("hibernate.hbm2ddl.auto", "update");
		map.put("hibernate.show_sql", true);
		map.put("hibernate.fomat_sql", true);
		//create LocalContainerEntityManagerFactoryBean class obj using EntityManagerFactoryBuilder object
		return emBuilder.dataSource(createOraDs()).packages("com.nt.entity.prod").properties(map).build(); 
	}
	
	@Bean("oraTxMgmr")
	@Primary
	public JpaTransactionManager createTxMgmrForOracle(@Qualifier("oraEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
}
