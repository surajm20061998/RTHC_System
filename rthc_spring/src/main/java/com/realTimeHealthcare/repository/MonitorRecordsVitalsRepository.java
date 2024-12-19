// File: src/main/java/com/example/healthcare_system/repository/MonitorRecordsVitalsRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.MonitorRecordsVitals;
import com.realTimeHealthcare.model.MonitorRecordsVitalsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonitorRecordsVitalsRepository extends JpaRepository<MonitorRecordsVitals, MonitorRecordsVitalsId> {
    // Find all vital records associated with a specific monitor
    List<MonitorRecordsVitals> findByMonitorMonitorId(Integer monitorId);

    // Find all vital records associated with a specific vital record
    List<MonitorRecordsVitals> findByVitalRecordVitalRecordId(Integer vitalRecordId);

    // Additional custom query methods can be added here as needed
}
