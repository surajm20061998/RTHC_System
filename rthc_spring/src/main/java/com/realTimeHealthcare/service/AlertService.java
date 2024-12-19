// File: src/main/java/com/example/healthcare_system/service/AlertService.java
package com.realTimeHealthcare.service;

import com.realTimeHealthcare.exception.ResourceNotFoundException;
import com.realTimeHealthcare.model.Alert;
import com.realTimeHealthcare.repository.AlertRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlertService {

    private static final Logger logger = LoggerFactory.getLogger(AlertService.class);

    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    /**
     * Retrieve all alerts.
     *
     * @return List of all alerts.
     */
    public List<Alert> getAllAlerts() {
        logger.info("Fetching all alerts");
        return alertRepository.findAll();
    }

    /**
     * Retrieve an alert by its ID.
     *
     * @param id Alert ID.
     * @return Alert object.
     * @throws ResourceNotFoundException if alert is not found.
     */
    public Alert getAlertById(Integer id) {
        logger.info("Fetching alert with ID: {}", id);
        return alertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found with ID: " + id));
    }

    /**
     * Create or update an alert.
     *
     * @param alert Alert object to save.
     * @return Saved alert.
     */
    @Transactional
    public Alert saveAlert(Alert alert) {
        if (alert.getAlertId() == null) {
            logger.info("Creating new alert");
        } else {
            logger.info("Updating alert with ID: {}", alert.getAlertId());
        }
        return alertRepository.save(alert);
    }

    /**
     * Delete an alert by its ID.
     *
     * @param id Alert ID.
     * @throws ResourceNotFoundException if alert is not found.
     */
    @Transactional
    public void deleteAlert(Integer id) {
        logger.info("Deleting alert with ID: {}", id);
        Alert alert = alertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found with ID: " + id));
        alertRepository.delete(alert);
    }

    /**
     * Retrieve alerts by severity.
     *
     * @param severity Severity level.
     * @return List of alerts matching the severity.
     */
    public List<Alert> getAlertsBySeverity(String severity) {
        logger.info("Fetching alerts with severity: {}", severity);
        return alertRepository.findBySeverity(severity);
    }

    /**
     * Retrieve alerts by status.
     *
     * @param status Status of alerts.
     * @return List of alerts matching the status.
     */
    public List<Alert> getAlertsByStatus(String status) {
        logger.info("Fetching alerts with status: {}", status);
        return alertRepository.findByStatus(status);
    }

    /**
     * Retrieve alerts associated with a specific staff member.
     *
     * @param staffId Staff ID.
     * @return List of alerts linked to the staff member.
     */
    public List<Alert> getAlertsByStaffId(Integer staffId) {
        logger.info("Fetching alerts associated with staff ID: {}", staffId);
        return alertRepository.findAlertsByStaffId(staffId);
    }

    /**
     * Retrieve alerts based on multiple criteria (e.g., severity and status).
     *
     * @param severity Severity level.
     * @param status   Status of alerts.
     * @return List of alerts matching the criteria.
     */
    public List<Alert> getAlertsBySeverityAndStatus(String severity, String status) {
        logger.info("Fetching alerts with severity: {} and status: {}", severity, status);
        return alertRepository.findBySeverityAndStatus(severity, status);
    }

    // Additional business logic methods can be added here as needed
}
