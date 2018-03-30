package com.demo.emp.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressDto {

	
	private Long id;
	
	@NotNull
    @Size(min=2, max=30)
	private String addrLn1;
	
	
	private String addrLn2;
	
	@NotNull
    @Size(min=2, max=30)
	private String city;
	
	
	@NotNull
    @Size(min=2, max=30)
	private String state;
	
	@NotNull
    @Size(min=5, max=6)
	private String zip;

	public AddressDto() {
		super();
	}

	public AddressDto(Long id, String addrLn1, String addrLn2, String city, String state, String zip) {
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

	@Override
	public String toString() {
		return "AddressDto [id=" + id + ", addrLn1=" + addrLn1 + ", addrLn2=" + addrLn2 + ", city=" + city + ", state="
				+ state + ", zip=" + zip + "]";
	}


	

}
