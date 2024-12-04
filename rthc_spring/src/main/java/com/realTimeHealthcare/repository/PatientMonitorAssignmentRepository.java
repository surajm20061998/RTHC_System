// File: src/main/java/com/example/healthcare_system/repository/PatientMonitorAssignmentRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.PatientMonitorAssignment;
import com.realTimeHealthcare.model.PatientMonitorAssignmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMonitorAssignmentRepository extends JpaRepository<PatientMonitorAssignment, PatientMonitorAssignmentId> {
    // Custom query methods can be added here
}
