package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.DeviceTypeDefinesMonitor;
import com.realTimeHealthcare.model.DeviceTypeDefinesMonitorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceTypeDefinesMonitorRepository extends JpaRepository<DeviceTypeDefinesMonitor, DeviceTypeDefinesMonitorId> {
    // Custom query methods can be added here
}
