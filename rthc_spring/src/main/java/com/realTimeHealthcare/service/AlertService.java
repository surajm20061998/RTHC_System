// File: src/main/java/com/example/healthcare_system/service/AlertService.java
package com.realTimeHealthcare.service;

import com.realTimeHealthcare.model.Alert;
import com.realTimeHealthcare.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    // Get all alerts
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    // Get alert by ID
    public Alert getAlertById(Integer id) {
        return alertRepository.findById(id).orElse(null);
    }

    // Add or update alert
    public Alert saveAlert(Alert alert) {
        return alertRepository.save(alert);
    }

    // Delete alert
    public void deleteAlert(Integer id) {
        alertRepository.deleteById(id);
    }

    // Custom methods
    public List<Alert> getAlertsBySeverity(String severity) {
        return alertRepository.findBySeverity(severity);
    }

    public List<Alert> getAlertsByStatus(String status) {
        return alertRepository.findByStatus(status);
    }
}
