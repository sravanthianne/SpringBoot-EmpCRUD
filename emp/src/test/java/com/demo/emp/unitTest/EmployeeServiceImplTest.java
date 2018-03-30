package com.demo.emp.unitTest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.demo.emp.domain.Employee;
import com.demo.emp.repositories.EmployeeRepository;
import com.demo.emp.service.EmployeeServiceImpl;
import com.demo.emp.service.dto.EmployeeDto;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
	

	@Mock
	EmployeeRepository employeeRepository;
	
	@InjectMocks
	EmployeeServiceImpl empService;
	
	DateFormat dateFormat = null; 

	@Before
    public void setUp() {
		
		
		empService =  new EmployeeServiceImpl(employeeRepository);
     	dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    }

	@Test
	public void testRetrieveAllEmployees() {
		
				
		Employee emp1 = null;
		Employee emp2 = null;
		Employee emp3 = null;
		try {
			emp1 = new Employee(null, "Test1 First", "Test1 Last", dateFormat.parse("11-11-1981"), (long) 123456789);
		    emp2 = new Employee(null, "Test2 First", "Test2 Last", dateFormat.parse("11-11-1982"), (long) 123456788);
		    emp3 = new Employee(null, "Test3 First", "Test3 Last", dateFormat.parse("11-11-1983"), (long) 123456787);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Employee> listEmp = new ArrayList<Employee>();
		
		listEmp.add(emp1);		
		listEmp.add(emp2);
		listEmp.add(emp3);
		
		
		when(employeeRepository.findAll()).thenReturn(listEmp);
				
		List<EmployeeDto> empListNew = empService.loadAll();
		
		for(EmployeeDto e : empListNew) {
			
			System.out.println(e.toString());
			
		}
		
		assertTrue(empListNew.size()==3);
	}

	@Test
	public void testSaveEmployee() {
		//fail("Not yet implemented");
	}

	@Test
	public void testRetrieveEmployeeById() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployee() {
		//fail("Not yet implemented");
	}

}
