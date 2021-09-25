package com.davacomint.employeemanagementsystem.service;

import com.davacomint.employeemanagementsystem.model.Employee;
import com.davacomint.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private  EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void createEmployee(Employee employee) {
        this.employeeRepository.save(employee);}

    @Override
    public Employee findByEmailAndPassword(String email, String password) {

        return employeeRepository.findEmployeeByEmailAndPassword(email, password).get();
    }
}
