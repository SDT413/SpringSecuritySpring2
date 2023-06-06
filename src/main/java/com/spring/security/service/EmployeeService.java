package com.spring.security.service;

import com.spring.security.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public void deleteEmployee(int id);

    Employee getEmployee(int id);
}
