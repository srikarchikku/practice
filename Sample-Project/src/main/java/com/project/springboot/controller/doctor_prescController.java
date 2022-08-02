package com.project.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.springboot.dto.DoctorPrescriptionDto;
import com.project.springboot.entity.Doctor_Presciption;
import com.project.springboot.service.Doctor_PresciptionService;


@RestController
@RequestMapping("/doctorprescription")
public class doctor_prescController {
	
	@Autowired
	Doctor_PresciptionService doctorPresciptionService;
	
	@GetMapping
	public List<DoctorPrescriptionDto> getAllPencils()
	{
		return doctorPresciptionService.getAllDoctorPresciption();
		
	}
	
	@GetMapping("/{id}")
	public DoctorPrescriptionDto getdoctor(@PathVariable("id") long id)
	{
		return doctorPresciptionService.getdoctorspresById(id);
		
	}
	
	@PostMapping
	public DoctorPrescriptionDto createDoctor(@Valid @RequestBody DoctorPrescriptionDto doctorPrescriptionDto)
	{
		return doctorPresciptionService.createDoctorPresciption(doctorPrescriptionDto);
	}
	
	@PutMapping("/{id}")
	public DoctorPrescriptionDto Update(@RequestBody Doctor_Presciption doctorpres, @PathVariable("id") long id)
	{
		return doctorPresciptionService.Update(doctorpres, id);
	}
	
	@DeleteMapping("/{id}")
	public String Delete(@PathVariable("id") long id)
	{
		doctorPresciptionService.Delete(id);
		return "Deleted Successfully!";
	}

}
