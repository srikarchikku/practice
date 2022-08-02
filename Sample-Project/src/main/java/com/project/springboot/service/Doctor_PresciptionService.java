package com.project.springboot.service;

import com.project.springboot.Repository.DoctorPresciptionRepository;
import com.project.springboot.Repository.DoctorRepository;
import com.project.springboot.Repository.PatientsRepository;
import com.project.springboot.dto.DoctorPrescriptionDto;
import com.project.springboot.entity.Doctor_Presciption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class Doctor_PresciptionService {
	
	@Autowired
	DoctorPresciptionRepository doctorPresciptionRepository;
	@Autowired
	PatientsRepository patientsRepository;
	@Autowired
	DoctorRepository doctorRepository;
	
	public DoctorPrescriptionDto createDoctorPresciption(DoctorPrescriptionDto doctorPrescriptionDto)
	{
		Doctor_Presciption doctor_presciption = Doctor_Presciption.builder().diagnosis(doctorPrescriptionDto.getDiagnosis())
				.review_date(doctorPrescriptionDto.getReview_date())
				.doctor(doctorRepository.findDoctorByName(doctorPrescriptionDto.getDoctorName()))
				.patient(patientsRepository.findPatientByName(doctorPrescriptionDto.getPatientName())).build();
		doctorPresciptionRepository.save(doctor_presciption);
		return ConverttoDto(doctor_presciption);
	}
	
	public List<DoctorPrescriptionDto> getAllDoctorPresciption()
	{
		return doctorPresciptionRepository.findAll()
				.stream().map(this::ConverttoDto).collect(Collectors.toList());
		 	
	}
	
	public DoctorPrescriptionDto getdoctorspresById (long id)
	{
		Doctor_Presciption doc= doctorPresciptionRepository.findById(id).get();
		return ConverttoDto(doc);
	}
	
	public void Delete(long id)
	{
		doctorPresciptionRepository.deleteById(id);
	}
	
	public DoctorPrescriptionDto Update(Doctor_Presciption doctorPresciption, long id)
	{
		Doctor_Presciption existingdocprescription= doctorPresciptionRepository.findById(id).orElse(null);

		existingdocprescription.setDiagnosis(doctorPresciption.getDiagnosis());
		existingdocprescription.setReview_date(doctorPresciption.getReview_date());

		doctorPresciptionRepository.save(existingdocprescription);
		return ConverttoDto(existingdocprescription);
	}
	
	private DoctorPrescriptionDto ConverttoDto(Doctor_Presciption doctor_presciption)
	{
		return new DoctorPrescriptionDto(doctor_presciption.getId(),doctor_presciption.getDiagnosis(),doctor_presciption.getReview_date(),
				doctor_presciption.getDoctors().getDoctorName(),doctor_presciption.getPatients().getPatientName());
	}
	private Doctor_Presciption ConverttoEntity(DoctorPrescriptionDto doctorPrescriptionDto)
	{
		return new Doctor_Presciption(doctorPrescriptionDto.getDiagnosis(),doctorPrescriptionDto.getReview_date(),
				doctorRepository.findDoctorByName(doctorPrescriptionDto.getDoctorName()),
				patientsRepository.findPatientByName(doctorPrescriptionDto.getPatientName()));
	}

//	    doctor_presciption.setDiagnosis(doctorPrescriptionDto.getDiagnosis());
//		doctor_presciption.setReview_date(doctorPrescriptionDto.getReview_date());
//		var patients = patientsRepository.findByPatientName(doctorPrescriptionDto.getPatientName());
//		var doctors = doctorRepository.findByDoctorName(doctorPrescriptionDto.getDoctorName());
//		if(!patients.isEmpty())
//		{
//			doctor_presciption.setPatients(patients.get());
//		}
//		if(!doctors.isEmpty())
//		{
//			doctor_presciption.setDoctors(doctors.get());
//		}
	
	
}
