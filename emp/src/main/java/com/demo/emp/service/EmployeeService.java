package com.demo.emp.service;

import java.util.List;

import com.demo.emp.service.dto.EmployeeDto;


public interface EmployeeService {
  public List<EmployeeDto> loadAll();
  public EmployeeDto getEmployee(long empId);
  public EmployeeDto saveEmployee(EmployeeDto employee);
  public EmployeeDto updateEmployee(EmployeeDto employee);
  public boolean deleteEmployee(long empId);

}
