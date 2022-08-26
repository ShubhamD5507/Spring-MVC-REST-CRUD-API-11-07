package com.springmvc.rest.config;


import java.util.Properties;

import javax.sql.DataSource;
import static org.hibernate.cfg.AvailableSettings.FORMAT_SQL;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.DIALECT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = "com.springmvc.rest")
public class MyAppConfig implements WebMvcConfigurer {
	
	@Autowired
	Environment env;
	
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
		
		return dataSource;
	}
	public Properties getProperties() {
		Properties prop = new Properties();
		
		prop.put(DIALECT, env.getRequiredProperty(DIALECT));
		prop.put(FORMAT_SQL, env.getRequiredProperty(FORMAT_SQL));
		prop.put(SHOW_SQL, env.getRequiredProperty(SHOW_SQL));
		prop.put(HBM2DDL_AUTO, env.getRequiredProperty(HBM2DDL_AUTO));
		
		return prop;
	}
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setHibernateProperties(getProperties());
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] {"com.springmvc.rest.entity"});
		
		return sessionFactory;
	}
}
