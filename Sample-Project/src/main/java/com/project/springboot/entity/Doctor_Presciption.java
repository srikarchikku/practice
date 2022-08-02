package com.project.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor_Presciption {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String diagnosis;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date review_date;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	@CreatedDate
	private Date created_at;
	@PrePersist
	private void onCreate()
	{
		created_at= new Date();
		updated_at = new Date();
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	@LastModifiedDate
	private Date updated_at;
	@OneToOne( cascade=CascadeType.ALL)
	@JoinColumn(name="doctor_id", referencedColumnName= "id")
	private Doctors doctor;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="patient_id", referencedColumnName= "id")
	private Patients patient;

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
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Doctors getDoctors() {
		return doctor;
	}
	public void setDoctors(Doctors doctors) {
		this.doctor = doctor;
	}
	public Patients getPatients() {
		return patient;
	}

	public void setPatients(Patients patients) {
		this.patient = patient;
	}

	public Doctor_Presciption(String diagnosis, Date review_date,  Doctors doctor, Patients patient) {
		this.diagnosis = diagnosis;
		this.review_date = review_date;
		this.doctor = doctor;
		this.patient = patient;
	}
}
