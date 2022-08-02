package com.project.springboot.service;

import com.project.springboot.Repository.DoctorRepository;
import com.project.springboot.Repository.HospitalsRepository;
import com.project.springboot.dto.DoctorDto;
import com.project.springboot.entity.Doctors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class DoctorsService {
	
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	HospitalsRepository hospitalsRepository;
	@Autowired
	ModelMapper mapper;


	public DoctorDto createDoctor(DoctorDto doctorDto)
	{
		Doctors doctor1= Doctors.builder().doctorName(doctorDto.getDoctorName())
				.specilization(doctorDto.getSpecilization()).build();
		var hospitals =  hospitalsRepository.findByHospitalName(doctorDto.getHospitalName());
		if (!hospitals.isEmpty()) {
			doctor1.setHospital(hospitals.get());
		}
		doctorRepository.save(doctor1);
		return ConverttoDto(doctor1);
	}
	
	public List<DoctorDto> getAllDoctors()
	{
		return doctorRepository.findAll()
				.stream().map(this::ConverttoDto).collect(Collectors.toList());

	}
	
	public DoctorDto getdoctorsById (long id)
	{
		Doctors doctors=doctorRepository.findById(id).get();

		return ConverttoDto(doctors);
	}
	
	public void deletedoctorsById (long id)
	{
		doctorRepository.deleteById(id);
		
	}
	
	public DoctorDto update(DoctorDto doctorDto, long id)
	{
		Doctors doctors = ConverttoEntity(doctorDto);
		doctors= doctorRepository.findById(id).orElse(null);

		doctors.setDoctorName(doctorDto.getDoctorName());
		doctors.setSpecilization(doctorDto.getSpecilization());

		doctorRepository.save(doctors);
		return ConverttoDto(doctors);
	}
	
	private DoctorDto ConverttoDto(Doctors doctor)
	{
		return mapper.map(doctor, DoctorDto.class);
	}

	private Doctors ConverttoEntity(DoctorDto doctor)
	{
		return mapper.map(doctor, Doctors.class);
	}
}
