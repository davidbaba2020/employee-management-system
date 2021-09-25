package com.davacomint.employeemanagementsystem.service;

import com.davacomint.employeemanagementsystem.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void createEmployee(Employee employee);
    Employee findByEmailAndPassword(String email, String password);
}
