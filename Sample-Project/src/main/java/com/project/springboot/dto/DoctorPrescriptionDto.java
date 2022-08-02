package com.project.springboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DoctorPrescriptionDto {
	
	private long id;
	private String diagnosis;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date review_date;
	private String doctorName;
	private String patientName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public Date getReview_date() {
		return review_date;
	}
	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public DoctorPrescriptionDto(long id, String diagnosis, Date review_date, String doctorName, String patientName) {
		this.id = id;
		this.diagnosis = diagnosis;
		this.review_date = review_date;
		this.doctorName = doctorName;
		this.patientName = patientName;
	}
}
