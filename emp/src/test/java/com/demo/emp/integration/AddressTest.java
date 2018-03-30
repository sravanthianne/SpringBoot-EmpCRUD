package com.demo.emp.integration;

import static org.junit.Assert.*;

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

import com.demo.emp.domain.Address;
import com.demo.emp.repositories.EmployeeRepository;
import com.demo.emp.service.EmployeeService;
import com.demo.emp.service.EmployeeServiceImpl;
import com.demo.emp.service.dto.AddressDto;
import com.demo.emp.service.dto.EmployeeDto;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AddressTest {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	final static Logger log = Logger.getLogger(AddressTest.class);
	
	EmployeeService service = null;

	@Before
    public void setUp() {
		
		
		service =  new EmployeeServiceImpl(employeeRepository);
	}

	
	
	
	@Test
	public void createEmpAddressTest() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		EmployeeDto emp = null;

	    try {
	    	
		emp = new EmployeeDto(null, "Test1 First", "Test1 Last", dateFormat.parse("11-11-1981"), (long) 123456789);
		
		AddressDto addr = new AddressDto(null, "addrLn1", "addrLn2", "city", "state", "11111");
		emp.setAddress(addr);
		
		emp = service.saveEmployee(emp);
		}catch(Exception error){
			
			log.error("exception in inserting employee and address", error);
		}
	    
	    log.debug("address id after insert" + emp.getAddress().getId());
	    assertNotNull(emp.getAddress().getId());
	}
		
	
	
	@Test
	public void updateEmpAddressTest() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		EmployeeService service = new EmployeeServiceImpl(employeeRepository);
		
		EmployeeDto emp = null;

	    try {
	    	
		emp = new EmployeeDto(null, "Test1 First", "Test1 Last", dateFormat.parse("11-11-1981"), (long) 123456789);
		AddressDto addr = new AddressDto(null, "addrLn1", "addrLn2", "city", "state", "11111");
		emp.setAddress(addr);
		// create employee
		emp = service.saveEmployee(emp);
		log.debug("Emp address before update" + emp.getAddress().toString());
		
		// update address
		emp.getAddress().setAddrLn1("updated");
		emp = service.saveEmployee(emp);
	    }catch(Exception error){
			
			log.error("exception in updating employee and address", error);
		}

	    log.debug("Emp address after update" + emp.getAddress().toString());
	    assertEquals("updated", emp.getAddress().getAddrLn1());
	}
	
}
