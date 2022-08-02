package com.project.springboot.service;

import com.project.springboot.Repository.DoctorPresciptionRepository;
import com.project.springboot.Repository.PatientsRepository;
import com.project.springboot.dto.PatientsDto;
import com.project.springboot.entity.Patients;
import com.project.springboot.exception.IdNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PatientsdtoService {
	
	@Autowired
	PatientsRepository repo;
	
	
	@Autowired
	DoctorPresciptionRepository drepo;
	@Autowired
	ModelMapper mapper;
	@Autowired
	DoctorsService dservice;

	


	public PatientsDto create(PatientsDto patient) {

		Patients newPatient = Patients.builder().patientName(patient.getPatientName()).phone_no(patient.getPhone_no())
				.doj(patient.getDoj())
				.vaccination_status(patient.getVaccination_status()).build();
		log.info("The data has been added....");
		repo.save(newPatient);
		return ConverttoDto(newPatient);
		//		PatientsDto patient1= ConverttoDto(newPatient);
//		patient1.getPatientName();
//        patient1.getPhone_no();
//		patient1.getDoj();
//		patient1.getVaccination_status();
	}

	@Async
	public CompletableFuture<List<PatientsDto>> getAllPatients()
	{
		System.out.println(Thread.currentThread().getName());
		List<PatientsDto> patientsDtos= repo.findAll()
				.stream()
				.map(this::ConverttoDto)
				.collect(Collectors.toList());
		return CompletableFuture.completedFuture(patientsDtos);

	}

	public CompletableFuture<List<PatientsDto>>  getAllpatientsbystatus (int number)
	{
//		System.out.println(Thread.currentThread().getName());
		List<PatientsDto> patientsDto= repo.findAllPatientsByStatus(number)
				.stream()
				.map(this::ConverttoDto)
				.collect(Collectors.toList());
		return CompletableFuture.completedFuture(patientsDto);
	}


	public PatientsDto getpatientById(long id) throws IdNotFoundException {
		Patients getPatient= repo.findById(id).orElseThrow(() -> new IdNotFoundException("Details not found for id: " + id));
		return ConverttoDto(getPatient);
	}
	public PatientsDto update(PatientsDto patient,long id) throws IdNotFoundException {
		Patients ExistingPatient= ConverttoEntity(patient);

		ExistingPatient= repo.findById(id).orElseThrow(() -> new IdNotFoundException("Details not found for id: " + id));
		ExistingPatient.setPatientName(patient.getPatientName());
		ExistingPatient.setPhone_no(patient.getPhone_no());
		ExistingPatient.setVaccination_status(patient.getVaccination_status());
		repo.save(ExistingPatient);
		return ConverttoDto(ExistingPatient);


	}

	public void delete(long id)
	{
		repo.deleteById(id);
	}
	
	
	private PatientsDto ConverttoDto(Patients patient)
	{
		return mapper.map(patient, PatientsDto.class);
		
	}
	
	private Patients ConverttoEntity(PatientsDto patient)
	{
		return mapper.map(patient, Patients.class);
		
	}

}
//newPatient.setPatientName(patient.getPatientName());
//		newPatient.setPhone_no(patient.getPhone_no());
//		newPatient.setDOJ(patient.getDoj());
//		newPatient.setVaccination_status(patient.getVaccination_status());