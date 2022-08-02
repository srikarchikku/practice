package com.project.springboot.dto;

public class PatientshospitalsDto {

    private long id;
    private String patientName;
    private String hospitalName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public PatientshospitalsDto(long id, String patientName, String hospitalName) {
        this.id = id;
        this.patientName = patientName;
        this.hospitalName = hospitalName;
    }
}
