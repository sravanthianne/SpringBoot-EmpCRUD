package com.demo.emp.service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.demo.emp.domain.Department;

public class EmployeeDto {
	
	
	private Long id;
		
	@NotNull
    @Size(min=2, max=30)
	private String firstname;
		  
	@NotNull
    @Size(min=2, max=30)
	private String lastname;
	
	@NotNull  
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date dob;
		  
	@NotNull
    @Size(min=9, max=9)
	private Long ssn;
	
	private AddressDto address;
	
	//private List<Department> departments;


	public EmployeeDto() {
		super();
	}


	public EmployeeDto(Long id, String firstname, String lastname, Date dob,
			Long ssn) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.ssn = ssn;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public Long getSsn() {
		return ssn;
	}


	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}


	public AddressDto getAddress() {
		return address;
	}


	public void setAddress(AddressDto address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", ssn=" + ssn + "]";
	}


	/*public List<Department> getDepartments() {
		return departments;
	}


	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	public void addDepartment(Department department) {
		if(this.departments == null)
			this.departments = new ArrayList<Department>();
		
		this.departments.add(department);
	}*/
	
	
}
