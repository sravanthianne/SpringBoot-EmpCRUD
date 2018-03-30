package com.demo.emp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.emp.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
