// File: src/main/java/com/example/healthcare_system/repository/PatientMonitorRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.PatientMonitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMonitorRepository extends JpaRepository<PatientMonitor, Integer> {
    // Find monitor by serial number
    PatientMonitor findBySerialNumber(String serialNumber);
}
