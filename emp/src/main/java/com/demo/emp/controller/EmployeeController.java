package com.demo.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.emp.domain.Employee;
import com.demo.emp.service.EmployeeService;
import com.demo.emp.service.dto.EmployeeDto;


@Controller
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/employees")
  public String getAllEmployees(Model model) {
    List<EmployeeDto> employeeList = employeeService.loadAll();

    model.addAttribute("employeeList", employeeList);

    return "employees"; 
  }
  
  @GetMapping("/employee")
  public String addNewEmp(Model model) {
	  
	  model.addAttribute("employee", new EmployeeDto());

	    return "employeeDetails"; 
  }
  
  @GetMapping("/employee/{id}")
  public String getEmployee(Model model, @PathVariable("id") long empId) {
	  
    EmployeeDto employee = employeeService.getEmployee(empId);

    model.addAttribute("employee", employee);

    return "employeeDetails"; 
  }
  
	
	@PostMapping("/employee")
	public String saveEmp(@ModelAttribute("employee") EmployeeDto emp) {
		
		if(emp.getId()==null || emp.getId()== 0)
			employeeService.saveEmployee(emp);
		else	
			employeeService.updateEmployee(emp);
		return "redirect:/employees";
		
	}
	

	@GetMapping("/employee/delete/{id}")
	public String deleteEmp(@PathVariable("id") long id) {
		
		employeeService.deleteEmployee(id);
		
		return "redirect:/employees";
		
	}
}
