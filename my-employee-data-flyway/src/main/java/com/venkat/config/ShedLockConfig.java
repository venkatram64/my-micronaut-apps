package com.venkat.config;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Primary;
import io.micronaut.context.annotation.Requires;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbc.JdbcLockProvider;
import org.flywaydb.core.Flyway;


import javax.sql.DataSource;

@Factory
@Slf4j
@Requires(beans = DataSource.class)  // Only create if DataSource exists
public class ShedLockConfig {



//    @Singleton
//    public LockProvider lockProvider(TransactionOperations<Connection> transactionOperation) {
//        return new MicronautJdbcLockProvider(transactionOperation);
//    }

//    @Singleton
//    public LockProvider lockProvider(DataSource dataSource) {
//        // Create the provider with table name explicitly
//        return new MicronautJdbcLockProvider(dataSource,"shedlock");
//    }

//    @Singleton
//    public LockProvider lockProvider(DataSource dataSource) {
//        log.info("Creating JdbcLockProvider with explicit table name");
//
//        // Try with table name parameter if available
//        try {
//            // This constructor might be available: JdbcLockProvider(DataSource, String tableName)
//            return new JdbcLockProvider(dataSource, "shedlock");
//        } catch (Exception e) {
//            log.warn("Constructor with table name not available, trying simple constructor");
//            return new JdbcLockProvider(dataSource);
//        }
//    }

    @Singleton
    @Primary
    public LockProvider lockProvider(DataSource dataSource) {
        log.info("Creating MicronautJdbcLockProvider with table name 'shedlock'");
        return new JdbcLockProvider(dataSource, "shedlock");
    }

}
