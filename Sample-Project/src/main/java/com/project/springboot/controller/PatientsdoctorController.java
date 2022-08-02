package com.project.springboot.controller;

import com.project.springboot.dto.PatientsdoctorDto;
import com.project.springboot.service.PatientsdoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patientsdoctor")
public class PatientsdoctorController {
    @Autowired
    PatientsdoctorService patientsdoctorService;

    @PostMapping
    public PatientsdoctorDto create(@RequestBody PatientsdoctorDto patientsdoctorDto)
    {
        return patientsdoctorService.create(patientsdoctorDto);
    }
    @GetMapping
    public List<PatientsdoctorDto> getAllDetails()
    {
        return patientsdoctorService.getAllPatientdoctors();
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id)
    {
        patientsdoctorService.delete(id);
        return "Deleted Successfully!!!";
    }
}
