package com.anz.codingchallenge.accountservice;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableConfigurationProperties
@EnableJpaRepositories(basePackages = "com.anz.codingchallenge.accountservice.repository")
public class AppDatabaseConfig {

	@Bean
	@Qualifier("appDataSource")
	@Primary
	@ConfigurationProperties(prefix="app.datasource.accountservice")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}
