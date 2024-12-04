// File: src/main/java/com/example/healthcare_system/service/PatientMonitorService.java
package com.realTimeHealthcare.service;

import com.realTimeHealthcare.model.PatientMonitor;
import com.realTimeHealthcare.repository.PatientMonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientMonitorService {

    @Autowired
    private PatientMonitorRepository monitorRepository;

    // Get all monitors
    public List<PatientMonitor> getAllMonitors() {
        return monitorRepository.findAll();
    }

    // Get monitor by ID
    public PatientMonitor getMonitorById(Integer id) {
        return monitorRepository.findById(id).orElse(null);
    }

    // Add or update monitor
    public PatientMonitor saveMonitor(PatientMonitor monitor) {
        return monitorRepository.save(monitor);
    }

    // Delete monitor
    public void deleteMonitor(Integer id) {
        monitorRepository.deleteById(id);
    }

    // Custom methods
    public PatientMonitor getMonitorBySerialNumber(String serialNumber) {
        return monitorRepository.findBySerialNumber(serialNumber);
    }
}
