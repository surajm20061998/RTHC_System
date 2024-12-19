// File: src/main/java/com/example/healthcare_system/repository/PatientHasVitalRecordsRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.PatientHasVitalRecords;
import com.realTimeHealthcare.model.PatientHasVitalRecordsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientHasVitalRecordsRepository extends JpaRepository<PatientHasVitalRecords, PatientHasVitalRecordsId> {
    // Find all records for a patient
    List<PatientHasVitalRecords> findByPatientPatientId(Integer patientId);

    // Find all records recorded by a specific staff member
    List<PatientHasVitalRecords> findByRecordedByStaffStaffId(Integer staffId);

    // Additional custom query methods can be added here as needed
}
