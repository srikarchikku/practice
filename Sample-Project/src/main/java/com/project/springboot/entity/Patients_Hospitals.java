package com.project.springboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Patients_Hospitals {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Patients.class)
	@JoinColumn(name="patient_id", referencedColumnName= "id")
	private Patients patients;
	
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=Hospitals.class)
	@JoinColumn(name="hospital_id", referencedColumnName= "id")
	private Hospitals hospitals;

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

	public Hospitals getHospitals() {
		return hospitals;
	}

	public void setHospitals(Hospitals hospitals) {
		this.hospitals = hospitals;
	}

	public Patients_Hospitals( Patients patients, Hospitals hospitals) {
		this.patients = patients;
		this.hospitals = hospitals;
	}
}
