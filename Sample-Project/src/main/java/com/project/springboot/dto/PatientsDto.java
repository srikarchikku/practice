package com.project.springboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class PatientsDto {
	

	
	private long id;
	private String patientName;
	private String phone_no;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date doj;
	private int vaccination_status;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	
	public int getVaccination_status() {
		return vaccination_status;
	}
	public void setVaccination_status(int vaccination_status) {
		this.vaccination_status = vaccination_status;
	}
	public Date getDoj() {
		return this.doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
}
