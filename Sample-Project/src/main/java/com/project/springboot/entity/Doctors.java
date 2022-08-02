package com.project.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	//@NotEmpty
	@NotBlank
	private String doctorName;
	private String specilization;
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

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "hospital_id", referencedColumnName = "id")
	private Hospitals hospitals;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecilization() {
		return specilization;
	}
	public void setSpecilization(String specilization) {
		this.specilization = specilization;
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
	public Hospitals getHospital() {
		return hospitals;
	}
	public void setHospital(Hospitals hospitals) {
		this.hospitals = hospitals;
	}

	
	
	
}
