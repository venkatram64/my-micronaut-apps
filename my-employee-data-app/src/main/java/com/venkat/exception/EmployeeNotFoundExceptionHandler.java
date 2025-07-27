package com.venkat.exception;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Singleton
@Requires(classes = {EmployeeNotFoundException.class, ExceptionHandler.class})
public class EmployeeNotFoundExceptionHandler implements ExceptionHandler<EmployeeNotFoundException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, EmployeeNotFoundException exception) {
        return HttpResponse.notFound(exception.getMessage());
    }
}
