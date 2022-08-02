package com.project.springboot.dto;

public class PatientsdoctorDto {

    private long id;
    private String patientName;
    private String doctorName;

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

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public PatientsdoctorDto(long id, String patientName, String doctorName) {
        this.id = id;
        this.patientName = patientName;
        this.doctorName = doctorName;
    }
}
