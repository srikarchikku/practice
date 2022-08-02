package com.project.springboot.Repository;

import com.project.springboot.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientsRepository extends JpaRepository<Patients, Long>{

    Optional<Patients> findByPatientName(String name);
    @Query(value= "SELECT * from patients p where p.vaccination_status=?1", nativeQuery= true)
    public List<Patients>  findAllPatientsByStatus(int number);

    @Query(value = "SELECT * from patients p where p.patient_name=?1", nativeQuery = true)
     Patients findPatientByName( String patientName);


}
