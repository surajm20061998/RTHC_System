// File: src/main/java/com/example/healthcare_system/repository/DeviceTypeDefinesMonitorRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.DeviceTypeDefinesMonitor;
import com.realTimeHealthcare.model.DeviceTypeDefinesMonitorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceTypeDefinesMonitorRepository extends JpaRepository<DeviceTypeDefinesMonitor, DeviceTypeDefinesMonitorId> {
    // Additional custom query methods can be added here as needed
}
