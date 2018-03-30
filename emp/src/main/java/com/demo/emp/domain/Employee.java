package com.demo.emp.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
		
	@Column(name = "FIRST_NAME")
	private String firstname;
		  
	@Column(name = "LAST_NAME")
	private String lastname;
		  
	@Column(name = "DATE_OF_BIRTH")
	private Date dob;
		  
	@Column(name = "SSN")
	private Long ssn;
	
	/*@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(name = "EMP_DEPARTMENT", joinColumns = @JoinColumn(name = "EMP_ID", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "DEPT_ID", referencedColumnName = "id"))
    private List<Department> departments;*/
	
	@OneToOne(cascade = CascadeType.ALL )
	@JoinColumn(name = "ADDRESS_ID", nullable = false)	
	private Address address;
	
	
  
	public Employee() {
		super();
	}

	public Employee(Long id, String firstname, String lastname, Date dob,
			Long ssn) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.ssn = ssn;
		/*this.departments = departments;
		this.address = address;*/
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
	
/*	public List<String> getDepartments() {
		return departments;
	}
	
	public void setDepartments(List<String> departments) {
		this.departments = departments;
	}*/
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}


  
}
