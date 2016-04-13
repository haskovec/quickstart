package org.jboss.narayana.quickstarts.springboot.jpa.config;

import com.arjuna.ats.internal.jta.transaction.arjunacore.TransactionManagerImple;
import com.arjuna.ats.jta.UserTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

/**
 * Created by jhaskovec on 4/4/16.
 */
@Configuration
@EnableTransactionManagement
public class TransactionConfig implements TransactionManagementConfigurer {
    private static final Logger log = LoggerFactory.getLogger(TransactionConfig.class);

    @Bean
    public PlatformTransactionManager transactionManager() {
        JtaTransactionManager tm = new JtaTransactionManager();
        tm.setUserTransaction(UserTransaction.userTransaction());
        tm.setTransactionManager(narayanaTransactionManager());
        tm.setTransactionManagerName("transactionManager");

        return tm;
    }

    @Bean
    public TransactionManager narayanaTransactionManager() {
        return new TransactionManagerImple();
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }
}
