package com.project.springboot.controller;

import com.project.springboot.dto.DoctorDto;
import com.project.springboot.service.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	
	@Autowired
	DoctorsService doctorService;
	
	@GetMapping
	public List<DoctorDto> getAllPencils()
	{
		return doctorService.getAllDoctors();

	}
	
	@GetMapping("{id}/")
	public DoctorDto getdoctor(@PathVariable("id") long id)
	{
		return doctorService.getdoctorsById(id);
		
	}
	
	@PostMapping
	public DoctorDto createDoctor(@Valid @RequestBody DoctorDto doctor)
	{
		return doctorService.createDoctor(doctor);
	}
	
	@PutMapping("/{id}")
	public DoctorDto Update(@RequestBody DoctorDto doctor, @PathVariable("id") long id)
	{
		return doctorService.update(doctor, id);
	}
	
	@DeleteMapping("/{id}")
	public String Delete(@PathVariable("id") long id)
	{
		doctorService.deletedoctorsById(id);
		return "Deleted Successfully!";
	}
	

}
