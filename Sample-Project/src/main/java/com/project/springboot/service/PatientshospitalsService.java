package com.project.springboot.service;

import com.project.springboot.Repository.HospitalsRepository;
import com.project.springboot.Repository.PatientsRepository;
import com.project.springboot.Repository.PatientshospitalsRepository;
import com.project.springboot.dto.PatientshospitalsDto;
import com.project.springboot.entity.Patients_Hospitals;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientshospitalsService {

    private PatientshospitalsRepository patientshospitalsRepository;
    private HospitalsRepository hospitalsRepository;
    private PatientsRepository patientsRepository;

    public PatientshospitalsService(PatientshospitalsRepository patientshospitalsRepository, HospitalsRepository hospitalsRepository,
                                    PatientsRepository patientsRepository) {
        this.patientshospitalsRepository = patientshospitalsRepository;
        this.hospitalsRepository = hospitalsRepository;
        this.patientsRepository = patientsRepository;
    }

    public PatientshospitalsDto create(PatientshospitalsDto patientshospitalsDto)
    {
        Patients_Hospitals patients_hospitals = new Patients_Hospitals(patientsRepository.findPatientByName(patientshospitalsDto.getPatientName()),
                hospitalsRepository.findHospitalByName(patientshospitalsDto.getHospitalName()));
        patientshospitalsRepository.save(patients_hospitals);
        return MaptoDto(patients_hospitals);
    }
    public List<PatientshospitalsDto> getAllPatientsandHospitals()
    {
        return patientshospitalsRepository.findAll()
                .stream().map(this::MaptoDto).collect(Collectors.toList());

    }
    public void delete(long id)
    {
        patientshospitalsRepository.deleteById(id);
    }

    private PatientshospitalsDto  MaptoDto(Patients_Hospitals patientsHospitals)
    {
        return new PatientshospitalsDto(patientsHospitals.getId(),patientsHospitals.getPatients().getPatientName(),
                patientsHospitals.getHospitals().getHospitalName());

    }

//        var patients = patientsRepository.findByPatientName(patientshospitalsDto.getPatientName());
//        var hospitals = hospitalsRepository.findByHospitalName(patientshospitalsDto.getHospitalName());
//        if(!hospitals.isEmpty())
//        {
//            patients_hospitals.setHospitals(hospitals.get());
//        }
//        if(!patients.isEmpty())
//        {
//            patients_hospitals.setPatients(patients.get());
//        }
}
