// File: src/main/java/com/example/healthcare_system/repository/PatientMonitorRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.PatientMonitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientMonitorRepository extends JpaRepository<PatientMonitor, Integer> {
    // Find monitor by serial number
    PatientMonitor findBySerialNumber(String serialNumber);

    // Find monitors by status
    List<PatientMonitor> findByStatus(String status);

    // Find monitors by manufacturer
    List<PatientMonitor> findByManufacturer(String manufacturer);

    // Additional custom query methods can be added here if needed
}
