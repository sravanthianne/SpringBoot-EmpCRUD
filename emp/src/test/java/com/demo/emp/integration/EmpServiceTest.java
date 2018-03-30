package com.demo.emp.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.emp.repositories.EmployeeRepository;
import com.demo.emp.service.EmployeeService;
import com.demo.emp.service.EmployeeServiceImpl;
import com.demo.emp.service.dto.AddressDto;
import com.demo.emp.service.dto.EmployeeDto;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmpServiceTest {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	final static Logger log = Logger.getLogger(EmpServiceTest.class);
	
	EmployeeService service = null;

	@Before
    public void setUp() {
		
		
		service =  new EmployeeServiceImpl(employeeRepository);
       
    }

	
	
	
	@Test
	public void createEmployeeTest() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		EmployeeDto emp = null;

	    try {
	    	
		emp = new EmployeeDto(null, "Test1 First", "Test1 Last", dateFormat.parse("11-11-1981"), (long) 123456789);
		AddressDto addr = new AddressDto(null, "addrLn1", "addrLn2", "city", "state", "11111");
		emp.setAddress(addr);
		emp = service.saveEmployee(emp);
		}catch(Exception error){
			
			log.error("exception in inserting employee", error);
		}
	    
	    log.debug("Emp id after insert" + emp.getId());
	    assertNotNull(emp.getId());
	}
		
	@Test
	public void getAllEmpTest() {
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		EmployeeDto emp = null;

	    try {
	    	
		emp = new EmployeeDto(null, "Test1 First", "Test1 Last", dateFormat.parse("11-11-1981"), (long) 123456789);
		AddressDto addr = new AddressDto(null, "addrLn1", "addrLn2", "city", "state", "11111");
		emp.setAddress(addr);
		service.saveEmployee(emp);
		
	    }catch(Exception error){
			
			log.error("exception in inserting employee", error);
		}
		
		List<EmployeeDto> employees = service.loadAll();

		assertEquals(1,employees.size());
	}
	
	@Test
	public void updateEmployeeTest() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		EmployeeService service = new EmployeeServiceImpl(employeeRepository);
		
		EmployeeDto emp = null;

	    try {
	    	
		emp = new EmployeeDto(null, "Test1 First", "Test1 Last", dateFormat.parse("11-11-1981"), (long) 123456789);
		AddressDto addr = new AddressDto(null, "addrLn1", "addrLn2", "city", "state", "11111");
		emp.setAddress(addr);
		// create employee
		emp = service.saveEmployee(emp);
		log.debug("Emp last name before update" + emp.getLastname());
		// update employee
		emp.setLastname("updated");
		emp = service.saveEmployee(emp);
		}catch(Exception e){
			System.out.println(e);
		}

	    log.debug("Emp last name after update" + emp.getLastname());
	    assertEquals("updated", emp.getLastname());
	}
	
	@Test
	public void deleteEmployeeTest() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		EmployeeService service = new EmployeeServiceImpl(employeeRepository);
		
		EmployeeDto emp = null;

	    try {
	    	
		emp = new EmployeeDto(null, "Test1 First", "Test1 Last", dateFormat.parse("11-11-1981"), (long) 123456789);
		AddressDto addr = new AddressDto(null, "addrLn1", "addrLn2", "city", "state", "11111");
		emp.setAddress(addr);
		emp = service.saveEmployee(emp);

		}catch(Exception error){
			log.error("exception in deleting employee", error);
		}
	    
	    log.debug("Emp id" + emp.getId());
	    assertTrue(service.deleteEmployee(emp.getId()));
	}

}
