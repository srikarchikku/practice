package com.project.springboot.dto;

import java.util.List;

import com.project.springboot.entity.Doctors;

public class HospitalsDto {
	
	private long id;
	private String hospitalName;
	private String street;
	private String city;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
	
	

}
