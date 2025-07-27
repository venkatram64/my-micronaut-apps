package com.venkat.service;


import com.venkat.exception.EmployeeNotFoundException;
import com.venkat.model.Employee;
import com.venkat.repository.EmployeeRepository;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getEmployees() {
        return this.employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        Employee savedEmp = this.employeeRepository.save(employee);
        return savedEmp;
    }

    public Employee getEmployee(int id){

        return this.employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for given id " + id));
    }

    public Employee updateEmployee(int id, Employee emp){
        Employee updateEmp = getEmployee(id);
        if(updateEmp != null){
            updateEmp.setDepartment(emp.getDepartment());
            updateEmp.setName(emp.getName());
            updateEmp.setEmail(emp.getEmail());
            updateEmp.setPhone(emp.getPhone());
            this.employeeRepository.update(updateEmp);
        }else {
            throw new EmployeeNotFoundException("Employee not found for given id " + id);
        }
        return updateEmp;
    }

    public void deleteEmployee(int id){
        this.employeeRepository.deleteById(id);
    }

    public long getEmployeeCount() {
        return this.employeeRepository.count();
    }
}
