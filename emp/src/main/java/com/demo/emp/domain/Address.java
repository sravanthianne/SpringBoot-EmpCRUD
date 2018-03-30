package com.demo.emp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "ADDR_LN1")
	private String addrLn1;

	@Column(name = "ADDR_LN2")
	private String addrLn2;


	@Column(name = "CITY")
	private String city;


	@Column(name = "STATE")
	private String state;

	@Column(name = "ZIP")
	private String zip;
	
	

	public Address() {
		super();
	}

	public Address(Long id, String addrLn1, String addrLn2, String city,
			String state, String zip) {
		super();
		this.id = id;
		this.addrLn1 = addrLn1;
		this.addrLn2 = addrLn2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddrLn1() {
		return addrLn1;
	}

	public void setAddrLn1(String addrLn1) {
		this.addrLn1 = addrLn1;
	}

	public String getAddrLn2() {
		return addrLn2;
	}

	public void setAddrLn2(String addrLn2) {
		this.addrLn2 = addrLn2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}



}
