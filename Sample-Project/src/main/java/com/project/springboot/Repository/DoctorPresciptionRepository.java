package com.project.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.entity.Doctor_Presciption;

public interface DoctorPresciptionRepository extends JpaRepository<Doctor_Presciption, Long>{

}
