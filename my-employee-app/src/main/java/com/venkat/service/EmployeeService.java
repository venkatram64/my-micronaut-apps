package com.venkat.service;


import com.venkat.exception.EmployeeNotFoundException;
import com.venkat.model.Employee;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee getEmployee(int id){

        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for given id " + id));
    }

    public Employee updateEmployee(int id, Employee emp){
        Employee updateEmp = getEmployee(id);
        if(updateEmp != null){
            updateEmp.setDepartment(emp.getDepartment());
            updateEmp.setName(emp.getName());
            updateEmp.setEmail(emp.getEmail());
            updateEmp.setPhone(emp.getPhone());
            int index = employees.indexOf(emp);
            if(index >= 0){
                employees.set(index, updateEmp);
            }
        }else {
            return null;
        }
        return updateEmp;
    }

    public void deleteEmployee(int id){
        Employee emp = getEmployee(id);
        employees.remove(emp);
    }


}
