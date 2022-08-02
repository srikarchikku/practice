package com.project.springboot.entity;


import com.project.springboot.CustomValidation.DatePattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;



@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	//@NotEmpty
	@NotBlank
	@Pattern(regexp = "[A-Za-z ]*$",message = "No numbers are accepted")
	private String patientName;
	
	@Column(name="phone_no", unique= true)
	@NotBlank(message="Mobile number cannot be empty")
	@Size(min=10,max=10)
	private String phone_no;
	
	@Column
	@DatePattern
	@Temporal(TemporalType.DATE)
	private Date doj;
	
	@Column
	private int vaccination_status;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	@CreatedDate
	private Date created_at= new Date();

	@PrePersist
	private void onCreate()
	{
		created_at= new Date();
		updated_at = new Date();
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	@UpdateTimestamp
	private Date updated_at= new Date();


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
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



//	public Patients(long id, String patientName, String phone_no, Date DOJ, int vaccination_status) {
//		this.id = id;
//		this.patientName = patientName;
//		this.phone_no = phone_no;
//		this.DOJ = DOJ;
//		this.vaccination_status = vaccination_status;
//	}
}
