package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.PatientAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatientAssessmentRepository extends JpaRepository<PatientAssessment, Integer> {

    /**
     * Find all assessments for a given patient ID.
     *
     * @param patientId The ID of the patient.
     * @return List of PatientAssessment records.
     */
    List<PatientAssessment> findByPatient_PatientId(Integer patientId);
}

