// File: src/main/java/com/example/healthcare_system/repository/PatientRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    // Find patients by status
    List<Patient> findByStatus(String status);

    // Find patients admitted after a certain date
    List<Patient> findByAdmissionDateAfter(Date date);
}
