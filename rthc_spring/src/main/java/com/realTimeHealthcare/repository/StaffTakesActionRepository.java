// File: src/main/java/com/example/healthcare_system/repository/StaffTakesActionRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.StaffTakesAction;
import com.realTimeHealthcare.model.StaffTakesActionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffTakesActionRepository extends JpaRepository<StaffTakesAction, StaffTakesActionId> {
    // Find all actions taken by a specific staff member
    List<StaffTakesAction> findByStaffStaffId(Integer staffId);

    // Find all actions associated with a specific alert
    List<StaffTakesAction> findByAlertAlertId(Integer alertId);
}
