package com.venkat.controller;

import com.venkat.model.Employee;
import com.venkat.service.EmployeeService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@Controller("api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Get
    public HttpResponse<List<Employee>> getEmployees() {
        return HttpResponse.ok(employeeService.getEmployees());
    }

    @Post
    public HttpResponse<Employee> addEmployee(@Body @Valid Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return HttpResponse.created(newEmployee);
    }

    @Get("/{id}")
    public HttpResponse<Employee> getEmployee(@PathVariable int id){
        return HttpResponse.ok(employeeService.getEmployee(id));
    }

    @Put("/{id}")
    public HttpResponse<Employee> updateEmployee(@PathVariable int id, @Body @Valid Employee emp){
        return HttpResponse.ok(employeeService.updateEmployee(id, emp));
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return HttpResponse.ok();
    }
}
