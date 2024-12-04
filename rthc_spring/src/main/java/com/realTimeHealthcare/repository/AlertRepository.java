// File: src/main/java/com/example/healthcare_system/repository/AlertRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Integer> {
    // Find alerts by severity
    List<Alert> findBySeverity(String severity);

    // Find alerts by status
    List<Alert> findByStatus(String status);
}
