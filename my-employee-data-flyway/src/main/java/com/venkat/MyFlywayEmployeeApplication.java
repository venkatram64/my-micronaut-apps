package com.venkat;

import io.micronaut.runtime.Micronaut;

public class MyFlywayEmployeeApplication {

    public static void main(String[] args) {
        //Micronaut.run(MyFlywayEmployeeApplication.class, args);
        Micronaut.build(args)
                .packages("com.venkat.config", "com.venkat.tasks")
                .start();
    }
}