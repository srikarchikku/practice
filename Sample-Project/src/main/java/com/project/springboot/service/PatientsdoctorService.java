package com.project.springboot.service;

import com.project.springboot.Repository.DoctorRepository;
import com.project.springboot.Repository.PatientsRepository;
import com.project.springboot.Repository.PatientsdoctorRepository;
import com.project.springboot.dto.PatientsdoctorDto;
import com.project.springboot.entity.Patients_Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientsdoctorService {

    private PatientsdoctorRepository patientsdoctorRepository;

    private PatientsRepository patientsRepository;

    private DoctorRepository doctorRepository;

    public PatientsdoctorService(PatientsdoctorRepository patientsdoctorRepository, PatientsRepository patientsRepository,
                                 DoctorRepository doctorRepository) {
        this.patientsdoctorRepository = patientsdoctorRepository;
        this.patientsRepository = patientsRepository;
        this.doctorRepository = doctorRepository;
    }

    public PatientsdoctorDto create( PatientsdoctorDto patientsdoctorDto)
    {
        var patientsdoctor= new Patients_Doctor(patientsRepository.findPatientByName(patientsdoctorDto.getPatientName()),
                doctorRepository.findDoctorByName(patientsdoctorDto.getDoctorName()));

        patientsdoctorRepository.save(patientsdoctor);
        return MaptoDto(patientsdoctor);
    }
    public List<PatientsdoctorDto> getAllPatientdoctors()
    {
        return patientsdoctorRepository.findAll()
                .stream().map(this::MaptoDto).collect(Collectors.toList());

    }
    public void delete(long id)
    {
        patientsdoctorRepository.deleteById(id);
    }

    private PatientsdoctorDto MaptoDto(Patients_Doctor patientsDoctor)
    {
        return new PatientsdoctorDto(patientsDoctor.getId(),patientsDoctor.getPatients().getPatientName(), patientsDoctor.getDoctors().getDoctorName());
    }


//        patientsdoctor.setId(patientsdoctorDto.getId());
//        patientsdoctor.setPatients(patientsRepository.findPatientByName(patientsdoctorDto.getPatientName()));
//        //System.out.println(patientsdoctor.getPatients());
//        patientsdoctor.setDoctors(doctorRepository.findDoctorByName(patientsdoctorDto.getDoctorName()));


//        Patients_Doctor patients_doctor= MaptoEntity(patientsdoctorDto);
//        var patients = patientsRepository.findByPatientName(patientsdoctorDto.getPatientName());
//        var doctors = doctorRepository.findByDoctorName(patientsdoctorDto.getDoctorName());
//        if(!patients.isEmpty())
//        {
//            patientsdoctor.setPatients(patients.get());
//        }
//        if(!doctors.isEmpty())
//        {
//            patientsdoctor.setDoctors(doctors.get());
//        }
}
