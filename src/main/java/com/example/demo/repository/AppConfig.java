package com.example.demo.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class AppConfig {
	@Bean
	public JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource) {
		return jdbcTemplate(hikariDataSource);
	}
}
