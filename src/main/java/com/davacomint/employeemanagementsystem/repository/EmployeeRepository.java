package com.davacomint.employeemanagementsystem.repository;

import com.davacomint.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional <Employee> findEmployeeByEmailAndPassword(String email, String password);
}
