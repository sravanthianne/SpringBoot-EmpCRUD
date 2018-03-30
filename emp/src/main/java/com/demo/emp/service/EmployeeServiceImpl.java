package com.demo.emp.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.emp.domain.Employee;
import com.demo.emp.repositories.EmployeeRepository;
import com.demo.emp.service.dto.EmployeeDto;
import com.demo.emp.util.MapperUtil;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
  final static Logger log = Logger.getLogger(EmployeeServiceImpl.class);	

  @Autowired
  private EmployeeRepository employeeRepository;
  
  

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<EmployeeDto> loadAll() {
		log.info("entering EmployeeServiceImpl - loadAll");
		
		List<Employee> modelList = employeeRepository.findAll();
		
		List<EmployeeDto> empDtoLsit = (List<EmployeeDto>) MapperUtil.mapList(modelList, EmployeeDto.class);
		
		log.info("exiting EmployeeServiceImpl - loadAll");
		return empDtoLsit;
	}

	@Override
	public EmployeeDto getEmployee(long empId) {
		log.info("entering EmployeeServiceImpl - getEmployee");
		
		Optional<Employee> empModel = employeeRepository.findById(empId);//  getOne(empId);
		
		EmployeeDto empDto = (EmployeeDto) MapperUtil.map(empModel.get(), EmployeeDto.class);
		
		log.info("exiting EmployeeServiceImpl - getEmployee");
		return empDto;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employee) {
		log.info("entering EmployeeServiceImpl - saveEmployee");
		
		Employee empModel = (Employee) MapperUtil.map(employee, Employee.class);
				
		empModel= employeeRepository.save(empModel);
		
		EmployeeDto empDto = (EmployeeDto) MapperUtil.map(empModel, EmployeeDto.class);
		
		log.info("exiting EmployeeServiceImpl - saveEmployee");
		return empDto;

	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employee) {
		log.info("entering EmployeeServiceImpl - updateEmployee");
		
		Employee empModel = (Employee) MapperUtil.map(employee, Employee.class);
		
		empModel= employeeRepository.save(empModel);
		
		EmployeeDto empDto = (EmployeeDto) MapperUtil.map(empModel, EmployeeDto.class);
		
		log.info("exiting EmployeeServiceImpl - updateEmployee");
		return empDto;
	}

	@Override
	public boolean deleteEmployee(long empId) {
		log.info("entering EmployeeServiceImpl - deleteEmployee");	
		
		try{
			log.debug("employee id  to delete " + empId);
			
			employeeRepository.deleteById(empId);
			
		}catch(Exception error){
			log.error("exception in deleteing employee", error);
			return false;
		}
		
		log.info("exiting EmployeeServiceImpl - deleteEmployee");
		return true;
	}



}
