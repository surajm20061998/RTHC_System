// File: src/main/java/com/example/healthcare_system/service/PatientMonitorService.java
package com.realTimeHealthcare.service;

import com.realTimeHealthcare.exception.ResourceNotFoundException;
import com.realTimeHealthcare.model.PatientMonitor;
import com.realTimeHealthcare.repository.PatientMonitorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientMonitorService {

    private static final Logger logger = LoggerFactory.getLogger(PatientMonitorService.class);

    private final PatientMonitorRepository monitorRepository;

    public PatientMonitorService(PatientMonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    /**
     * Retrieve all patient monitors.
     *
     * @return List of all monitors.
     */
    public List<PatientMonitor> getAllMonitors() {
        logger.info("Fetching all patient monitors");
        return monitorRepository.findAll();
    }

    /**
     * Retrieve a patient monitor by its ID.
     *
     * @param id Monitor ID.
     * @return PatientMonitor object.
     * @throws ResourceNotFoundException if monitor is not found.
     */
    public PatientMonitor getMonitorById(Integer id) {
        logger.info("Fetching patient monitor with ID: {}", id);
        return monitorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PatientMonitor not found with ID: " + id));
    }

    /**
     * Create or update a patient monitor.
     *
     * @param monitor PatientMonitor object to save.
     * @return Saved PatientMonitor.
     */
    @Transactional
    public PatientMonitor saveMonitor(PatientMonitor monitor) {
        if (monitor.getMonitorId() == null) {
            logger.info("Creating new patient monitor");
        } else {
            logger.info("Updating patient monitor with ID: {}", monitor.getMonitorId());
        }
        return monitorRepository.save(monitor);
    }

    /**
     * Delete a patient monitor by its ID.
     *
     * @param id Monitor ID.
     * @throws ResourceNotFoundException if monitor is not found.
     */
    @Transactional
    public void deleteMonitor(Integer id) {
        logger.info("Deleting patient monitor with ID: {}", id);
        PatientMonitor monitor = monitorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PatientMonitor not found with ID: " + id));
        monitorRepository.delete(monitor);
    }

    /**
     * Retrieve a patient monitor by its serial number.
     *
     * @param serialNumber Serial number of the monitor.
     * @return PatientMonitor object.
     * @throws ResourceNotFoundException if monitor is not found.
     */
    public PatientMonitor getMonitorBySerialNumber(String serialNumber) {
        logger.info("Fetching patient monitor with serial number: {}", serialNumber);
        PatientMonitor monitor = monitorRepository.findBySerialNumber(serialNumber);
        if (monitor == null) {
            throw new ResourceNotFoundException("PatientMonitor not found with serial number: " + serialNumber);
        }
        return monitor;
    }

    /**
     * Retrieve monitors by status.
     *
     * @param status Status of monitors.
     * @return List of monitors matching the status.
     */
    public List<PatientMonitor> getMonitorsByStatus(String status) {
        logger.info("Fetching patient monitors with status: {}", status);
        return monitorRepository.findByStatus(status);
    }

    /**
     * Retrieve monitors by manufacturer.
     *
     * @param manufacturer Manufacturer name.
     * @return List of monitors manufactured by the specified manufacturer.
     */
    public List<PatientMonitor> getMonitorsByManufacturer(String manufacturer) {
        logger.info("Fetching patient monitors manufactured by: {}", manufacturer);
        return monitorRepository.findByManufacturer(manufacturer);
    }

    // Additional business logic methods can be added here as needed
}
