package com.venkat.debug;

import io.micronaut.context.annotation.Requires;
import jakarta.inject.Singleton;
import javax.sql.DataSource;

@Singleton
@Requires(beans = DataSource.class)
public class DataSourceVerifier {

    public DataSourceVerifier(DataSource dataSource) {
        System.out.println(">>>>>> DATA SOURCE IS AVAILABLE: " + dataSource);
        try {
            System.out.println(">>>>>> CONNECTION TEST: " +
                    dataSource.getConnection().getMetaData().getDatabaseProductName());
        } catch (Exception e) {
            System.out.println(">>>>>> CONNECTION FAILED: " + e.getMessage());
        }
    }
}