package com.project.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.dto.HospitalsDto;
import com.project.springboot.entity.Hospitals;
import com.project.springboot.service.HospitalsDtoService;



@RestController
@RequestMapping("/hospitals")
public class HospitalsController {
	
	@Autowired
	HospitalsDtoService service;
	
	
	@GetMapping()
	public List<HospitalsDto> getallHospitals()
	{
		return service.GetAllHospitals();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HospitalsDto> getHospital(@PathVariable("id") long id)
	{
		HospitalsDto hosp= service.GetHospitalById(id);
		return new ResponseEntity<HospitalsDto>(hosp, HttpStatus.FOUND);
	}
	
	@PostMapping()
	public ResponseEntity<HospitalsDto> createHospital(@Valid @RequestBody Hospitals hosp)
	{
		HospitalsDto hospital=service.Create(hosp);
		return new ResponseEntity<HospitalsDto>(hospital, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public HospitalsDto UpdateHospital(@RequestBody Hospitals hosp, @PathVariable("id") long id)
	{
		return service.Update(hosp,id);
		 
	}
	
//	@PatchMapping("/{id}")
//	public HospitalsDto PatchHospital(@RequestBody Hospitals hosp, @PathVariable("id") long id)
//	{
//		return service.Patch(hosp,id);
//
//	}
	
	@DeleteMapping("/{id}")
	public String DeleteHospital(@PathVariable("id") long id)
	{
		service.Delete(id);
		return "Deleted Successfully!";
	}

}
