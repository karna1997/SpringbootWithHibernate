package com.example.springhibernatedemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.example.springhibernatedemo.pojo.Country;
import com.example.springhibernatedemo.pojo.Employee;

@Configuration
public class ConfigurationClass {
	@Autowired
	DataSource datasource;

	@Bean
	public LocalSessionFactoryBean getFactoryBean() {
		LocalSessionFactoryBean factorybean = new LocalSessionFactoryBean();
		factorybean.setDataSource(datasource);
		factorybean.setAnnotatedClasses(Employee.class, Country.class);
		return factorybean;
	}

}
