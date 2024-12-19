// File: src/main/java/com/example/healthcare_system/repository/PatientRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.Patient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    // Find patients by status
    List<Patient> findByStatus(String status);

    // Find patients admitted after a certain date
    List<Patient> findByAdmissionDateAfter(Date date);

    // Find patients by primary physician's staff ID
    List<Patient> findByPrimaryPhysicianStaffId(Integer physicianId);

    // Find patients by blood type
    List<Patient> findByBloodType(String bloodType);

    // Find patients by gender
    List<Patient> findByGender(String gender);

    @Query("SELECT p FROM Patient p WHERE p.admissionDate = CURRENT_DATE")
    List<Patient> findPatientsArrivingToday();

    @Query("SELECT p FROM Patient p WHERE p.riskLevel = 'High'")
    List<Patient> findHighRiskPatients();

    Patient findByPartId(Integer partId);

    /**
     * Fetch all patients with their vital records using EntityGraph.
     *
     * @return List of patients with their vital records.
     */
    @EntityGraph(attributePaths = {"patientHasVitalRecords", "patientHasVitalRecords.vitalRecord"})
    List<Patient> findAll();
}
