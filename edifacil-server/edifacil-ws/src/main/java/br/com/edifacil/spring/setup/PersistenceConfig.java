package br.com.edifacil.spring.setup;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("br.com.ichei.model.repository")
public class PersistenceConfig {
	
	/** logger. */
	private final static Logger LOGGER = LoggerFactory.getLogger(PersistenceConfig.class);
	
	@Bean
	public DataSource dataSource(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/iChei");
	    dataSource.setUsername("expressMatch");
	    dataSource.setPassword("expressMatch");
	    
	    return dataSource;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() throws ClassNotFoundException, NamingException {

		JpaTransactionManager transactionManager = new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(this.entityManagerFactoryBean().getObject());

		return transactionManager;
	}
	
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws ClassNotFoundException, NamingException {
		
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(this.dataSource());
		entityManagerFactoryBean.setPackagesToScan("br.com.ichei.model");
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);

		Properties jpaProterties = new Properties();
		jpaProterties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		jpaProterties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
		
		if (LOGGER.isDebugEnabled()) {
			jpaProterties.put("hibernate.format_sql", "true");
			jpaProterties.put("hibernate.show_sql", "true");
		}
		
		entityManagerFactoryBean.setJpaProperties(jpaProterties);

		return entityManagerFactoryBean;
	}
}