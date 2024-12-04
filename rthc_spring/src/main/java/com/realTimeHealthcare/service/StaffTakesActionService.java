// File: src/main/java/com/example/healthcare_system/service/StaffTakesActionService.java
package com.realTimeHealthcare.service;

import com.realTimeHealthcare.model.StaffTakesAction;
import com.realTimeHealthcare.model.StaffTakesActionId;
import com.realTimeHealthcare.repository.StaffTakesActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffTakesActionService {

    @Autowired
    private StaffTakesActionRepository staffTakesActionRepository;

    // Get all actions taken by staff
    public List<StaffTakesAction> getAllActions() {
        return staffTakesActionRepository.findAll();
    }

    // Get action by composite ID
    public StaffTakesAction getActionById(StaffTakesActionId id) {
        return staffTakesActionRepository.findById(id).orElse(null);
    }

    // Save action
    public StaffTakesAction saveAction(StaffTakesAction action) {
        return staffTakesActionRepository.save(action);
    }

    // Delete action
    public void deleteAction(StaffTakesActionId id) {
        staffTakesActionRepository.deleteById(id);
    }

    // Custom methods can be added here
}
