package com.project.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.Repository.HospitalsRepository;
import com.project.springboot.dto.HospitalsDto;
import com.project.springboot.entity.Hospitals;


@Service
public class HospitalsDtoService {
	
	@Autowired
	HospitalsRepository hrepo;
	@Autowired
	ModelMapper mapper;
	
	
	
	public HospitalsDto Create(Hospitals hosp) {
		
		 hrepo.save(hosp);
		 return ConverttoDto(hosp);
	}
	
	public List<HospitalsDto> GetAllHospitals()
	{
		return hrepo.findAll()
				.stream()
				.map(this::ConverttoDto)
				.collect(Collectors.toList());
	}
	
	public HospitalsDto GetHospitalById(long id) 
	{
		Hospitals getHospital= hrepo.findById(id).get();
		return ConverttoDto(getHospital);
	}
	public HospitalsDto Update(Hospitals hosp,long id)
	{
		Hospitals ExistingHosp= hrepo.findById(id).get();
		ExistingHosp.setHospitalName(hosp.getHospitalName());
		ExistingHosp.setStreet(hosp.getStreet());
		ExistingHosp.setCity(hosp.getCity());
		
		hrepo.save(ExistingHosp);
		return ConverttoDto(ExistingHosp);
	}
	
//	public HospitalsDto Patch(Hospitals hosp, long id) {
//		Hospitals ExistingHosp= hrepo.findById(id).get();
//		ExistingHosp.setDoctors(hosp.getDoctors());
//		hrepo.save(ExistingHosp);
//		return ConverttoDto(ExistingHosp);
//
//	}
	
	public void Delete(long id)
	{
		hrepo.deleteById(id);
	}
	
	
	private HospitalsDto ConverttoDto(Hospitals hosp)
	{
		return mapper.map(hosp, HospitalsDto.class);
		
	}

}
