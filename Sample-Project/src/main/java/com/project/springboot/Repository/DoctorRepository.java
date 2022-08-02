package com.project.springboot.Repository;

import com.project.springboot.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctors, Long> {

    Optional<Doctors> findByDoctorName(String name);

    @Query(value="SELECT * from doctors d where d.doctor_Name=?1", nativeQuery = true)
    Doctors findDoctorByName(String name);


}
