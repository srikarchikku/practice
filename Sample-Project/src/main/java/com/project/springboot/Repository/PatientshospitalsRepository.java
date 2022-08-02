package com.project.springboot.Repository;

import com.project.springboot.entity.Patients_Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientshospitalsRepository extends JpaRepository<Patients_Hospitals, Long> {
}
