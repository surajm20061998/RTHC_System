// File: src/main/java/com/example/healthcare_system/repository/PatientMonitorAssignmentRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.PatientMonitorAssignment;
import com.realTimeHealthcare.model.PatientMonitorAssignmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientMonitorAssignmentRepository extends JpaRepository<PatientMonitorAssignment, PatientMonitorAssignmentId> {
    // Find all monitor assignments for a patient
    List<PatientMonitorAssignment> findByPatientPatientId(Integer patientId);

    // Find all monitor assignments for a specific monitor
    List<PatientMonitorAssignment> findByMonitorMonitorId(Integer monitorId);

    // Find active assignments (endDate is null)
    List<PatientMonitorAssignment> findByEndDateIsNull();

    // Additional custom query methods can be added here as needed
}
