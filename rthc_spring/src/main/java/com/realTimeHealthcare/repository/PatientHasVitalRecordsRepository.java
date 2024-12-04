package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.PatientHasVitalRecords;
import com.realTimeHealthcare.model.PatientHasVitalRecordsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PatientHasVitalRecordsRepository extends JpaRepository<PatientHasVitalRecords, PatientHasVitalRecordsId> {
    // Find all records for a patient
    List<PatientHasVitalRecords> findByPatientPatientId(Integer patientId);
}
