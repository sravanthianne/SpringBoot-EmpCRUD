package com.demo.emp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.emp.domain.Address;
import com.demo.emp.domain.Employee;
import com.demo.emp.repositories.EmployeeRepository;
import com.demo.emp.service.dto.AddressDto;

@SpringBootApplication
public class EmpApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EmpApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(EmpApplication.class, args);
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	    EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
	    try {
	    	
	    Employee emp1 = new Employee(null, "Test1 First", "Test1 Last", dateFormat.parse("11-11-1981"), (long) 123456789);
		Address addr1 = new Address(null, "addrLn1", "addrLn2", "city", "state1", "11111");
		emp1.setAddress(addr1);
		employeeRepository.save(emp1);
		
		Employee emp2 = new Employee(null, "Test2 First", "Test2 Last", dateFormat.parse("11-11-1982"), (long) 223456789);
		Address addr2 = new Address(null, "addrLn2", "addrLn2", "city", "state2", "22222");
		emp2.setAddress(addr2);
		employeeRepository.save(emp2);
		
		Employee emp3 = new Employee(null, "Test3 First", "Test3 Last", dateFormat.parse("11-11-1983"), (long) 323456789);
		Address addr3 = new Address(null, "addrLn3", "addrLn2", "city", "state3", "33333");
		emp3.setAddress(addr3);
		employeeRepository.save(emp3);
		
		Employee emp4 = new Employee(null, "Test4 First", "Test4 Last", dateFormat.parse("11-11-1984"), (long) 423456789);
		Address addr4 = new Address(null, "addrLn4", "addrLn2", "city", "state4", "44444");
		emp4.setAddress(addr4);
		employeeRepository.save(emp4);
		
		Employee emp5 = new Employee(null, "Test5 First", "Test5 Last", dateFormat.parse("11-11-1985"), (long) 523456789);
		Address addr5 = new Address(null, "addrLn5", "addrLn2", "city", "state5", "55555");
		emp5.setAddress(addr5);
		employeeRepository.save(emp5);
		
		
	    } catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
