package com.project.springboot.Repository;

import com.project.springboot.entity.Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HospitalsRepository extends JpaRepository<Hospitals, Long>{
    Optional<Hospitals> findByHospitalName(String name);

    @Query(value = "SELECT * from hospitals h where h.hospital_name=?1", nativeQuery = true)
    Hospitals findHospitalByName(String hospitalName);
}
