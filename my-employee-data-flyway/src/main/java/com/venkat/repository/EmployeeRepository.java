package com.venkat.repository;

import com.venkat.model.Employee;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
