package com.project.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patients_Doctor {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Patients.class)
	@JoinColumn(name="patient_id", referencedColumnName= "id")
	private Patients patients;
	
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Doctors.class)
	@JoinColumn(name="doctor_id", referencedColumnName= "id")
	private Doctors doctors;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Patients getPatients() {
		return patients;
	}
	public void setPatients(Patients patients) {
		this.patients = patients;
	}

	public Doctors getDoctors() {
		return doctors;
	}
	public void setDoctors(Doctors doctors) {
		this.doctors = doctors;
	}

	public Patients_Doctor(Patients patients, Doctors doctors) {
		this.patients = patients;
		this.doctors = doctors;
	}
}
