package com.project.springboot.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
public class Hospitals {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique= true)
	@NotBlank
	private String hospitalName;
	
	private String street;
	
	@NotNull
	private String city;

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
	
	
}
