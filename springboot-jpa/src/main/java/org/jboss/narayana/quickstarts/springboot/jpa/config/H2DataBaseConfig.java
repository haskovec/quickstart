package org.jboss.narayana.quickstarts.springboot.jpa.config;

import org.apache.commons.dbcp2.managed.BasicManagedDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

@Configuration
public class H2DataBaseConfig {
    @Autowired
    private TransactionManager tm;

    @Bean
    DataSource getDataSource() {
        BasicManagedDataSource ds = new BasicManagedDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:~/test;DB_CLOSE_ON_EXIT=FALSE");
        ds.setUsername("sa");
        ds.setPassword("saPassword");
        ds.setTransactionManager(tm);

        return ds;
    }
}
