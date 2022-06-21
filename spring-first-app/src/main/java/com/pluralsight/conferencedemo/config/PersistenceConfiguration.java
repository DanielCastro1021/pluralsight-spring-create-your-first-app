package com.pluralsight.conferencedemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {
    @Value("${DB.URL}")
    private String url;
    @Value("${DB.USERNAME}")
    private String username;
    @Value("${DB.PASSWORD}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.url(url);
        builder.username(username);
        builder.password(password);
        System.out.println("PersistenceConfiguration.dataSource");
        return builder.build();
    }
}
