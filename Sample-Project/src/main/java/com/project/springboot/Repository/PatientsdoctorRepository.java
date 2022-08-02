package com.project.springboot.Repository;

import com.project.springboot.entity.Patients_Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsdoctorRepository extends JpaRepository<Patients_Doctor, Long> {
}
