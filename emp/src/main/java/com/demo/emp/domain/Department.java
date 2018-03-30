package com.demo.emp.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


//@Entity
//@Table(name = "department")
public class Department {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "DEPT_CODE")
	private String deptCode;

	@Column(name = "DEPT_NAME")
	private String deptName;
	
	@ManyToMany(mappedBy = "departments")
	private List<Employee> employees;

	public Department() {
		super();
	}

	public Department(Long id, String deptCode, String deptName) {
		super();
		this.id = id;
		this.deptCode = deptCode;
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptCode=" + deptCode + ", deptName=" + deptName + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	

	

}
