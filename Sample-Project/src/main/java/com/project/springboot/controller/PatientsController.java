package com.project.springboot.controller;

import com.project.springboot.dto.PatientsDto;
import com.project.springboot.exception.IdNotFoundException;
import com.project.springboot.service.PatientsdtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/patients")
public class PatientsController {
	
	@Autowired
	PatientsdtoService service;
	
	
	@GetMapping()
	public CompletableFuture<List<PatientsDto>> getallPatients()
	{
		return service.getAllPatients();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PatientsDto> getpatient(@PathVariable("id") long id) throws IdNotFoundException {
		PatientsDto patients= service.getpatientById(id);
		return new ResponseEntity<PatientsDto>(patients, HttpStatus.FOUND);
	}
	@GetMapping("/status/{vaccination_status}")
	public CompletableFuture<List<PatientsDto>> getAllpatientsbystatus(@PathVariable("vaccination_status") int num)
	{
		return service.getAllpatientsbystatus(num);
	}
	
	@PostMapping()
	public PatientsDto createPatient( @RequestBody @Valid PatientsDto patient)
	{
		return service.create(patient);

	}
	
	@PutMapping("/{id}")
	public PatientsDto Updatepatient(@RequestBody PatientsDto patient, @PathVariable("id") long id) throws IdNotFoundException {
		return service.update(patient,id);

	}
//	
//	@PatchMapping("/{id}")
//	public PatientsDto PatchHospital(@RequestBody Patients patient, @PathVariable("id") long id)
//	{
//		return service.Patch(patient,id);
//		 
//	}
//	
	@DeleteMapping("/{id}")
	public String DeletePatient(@PathVariable("id") long id)
	{
		service.delete(id);
		return "Deleted Successfully!";
	}

}

//	Map<String, Object> body = new HashMap<>();
//	List<String> errors = ex.getBindingResult()
//			.getFieldErrors()
//			.stream()
//			.map(x-> x.getDefaultMessage())
//			.collect(Collectors.toList());
//        body.put("errors", errors);
//				return new ResponseEntity<>(body, headers, status);
