package com.information.customer.config;

import com.mysql.cj.jdbc.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
public class DBConfig {

    @Autowired
    private ConfigurableEnvironment env;


    @Profile("local")
    @Bean
    public DataSource dataSourceLocal() throws SQLException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/loinsurance?createDatabaseIfNotExist=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriver(new Driver());
        return dataSource;
    }

    @Profile("prod")
    @Bean
    public DataSource dataSourceProd() throws SQLException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setUrl("jdbc:mysql://canada-insurance-instance-1.cfqctdytya09.us-east-2.rds.amazonaws.com:3306/loinsurance?createDatabaseIfNotExist=true");
        dataSource.setUsername("admin");
        dataSource.setPassword("Be.Cognizant2023!");
        /*dataSource.setUrl("jdbc:mysql://canada-insurance-instance-1.cfqctdytya09.us-east-2.rds.amazonaws.com:3306/loinsurance?createDatabaseIfNotExist=true");
        dataSource.setUsername("admin");
        dataSource.setPassword("Be.Cognizant2023!");*/
        dataSource.setDriver(new Driver());
        return dataSource;
    }

}
