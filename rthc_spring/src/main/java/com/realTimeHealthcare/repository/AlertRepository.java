// File: src/main/java/com/example/healthcare_system/repository/AlertRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Integer> {
    // Find alerts by severity
    List<Alert> findBySeverity(String severity);

    // Find alerts by status
    List<Alert> findByStatus(String status);

    // Find alerts by severity and status
    List<Alert> findBySeverityAndStatus(String severity, String status);

    // Custom query to fetch alerts associated with a specific staff member
    @Query("SELECT DISTINCT a FROM Alert a " +
           "JOIN a.vitalRecordsTriggered vta " +
           "JOIN vta.vitalRecord vr " +
           "JOIN vr.patientHasVitalRecords phr " +
           "JOIN phr.recordedByStaff s " +
           "WHERE s.staffId = :staffId")
    List<Alert> findAlertsByStaffId(@Param("staffId") Integer staffId);
}
