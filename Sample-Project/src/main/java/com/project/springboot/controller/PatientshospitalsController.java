package com.project.springboot.controller;

import com.project.springboot.dto.PatientshospitalsDto;
import com.project.springboot.service.PatientshospitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patientshospitals")
public class PatientshospitalsController {

    @Autowired
    PatientshospitalsService patientshospitalsService;
    @PostMapping
    public PatientshospitalsDto create(@RequestBody PatientshospitalsDto patientshospitalsDto)
    {
        return patientshospitalsService.create(patientshospitalsDto);
    }
    @GetMapping
    public List<PatientshospitalsDto> getallDetails()
    {
        return patientshospitalsService.getAllPatientsandHospitals();
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id)
    {
        patientshospitalsService.delete(id);
        return "Deleted Successfully";
    }
}
