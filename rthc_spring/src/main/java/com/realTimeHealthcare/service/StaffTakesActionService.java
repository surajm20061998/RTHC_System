// File: src/main/java/com/example/healthcare_system/service/StaffTakesActionService.java
package com.realTimeHealthcare.service;

import com.realTimeHealthcare.exception.ResourceNotFoundException;
import com.realTimeHealthcare.model.StaffTakesAction;
import com.realTimeHealthcare.model.StaffTakesActionId;
import com.realTimeHealthcare.repository.StaffTakesActionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffTakesActionService {

    private static final Logger logger = LoggerFactory.getLogger(StaffTakesActionService.class);

    private final StaffTakesActionRepository staffTakesActionRepository;

    public StaffTakesActionService(StaffTakesActionRepository staffTakesActionRepository) {
        this.staffTakesActionRepository = staffTakesActionRepository;
    }

    /**
     * Retrieve all actions taken by staff.
     *
     * @return List of all staff actions.
     */
    public List<StaffTakesAction> getAllActions() {
        logger.info("Fetching all staff actions");
        return staffTakesActionRepository.findAll();
    }

    /**
     * Retrieve a staff action by its composite ID.
     *
     * @param id Composite ID consisting of staff ID, alert ID, and action timestamp.
     * @return StaffTakesAction object.
     * @throws ResourceNotFoundException if action is not found.
     */
    public StaffTakesAction getActionById(StaffTakesActionId id) {
        logger.info("Fetching staff action with ID: {}", id);
        return staffTakesActionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StaffTakesAction not found with ID: " + id));
    }

    /**
     * Create or update a staff action.
     *
     * @param action StaffTakesAction object to save.
     * @return Saved StaffTakesAction.
     */
    @Transactional
    public StaffTakesAction saveAction(StaffTakesAction action) {
        if (action.getStaff() == null || action.getAlert() == null || action.getActionTimestamp() == null) {
            logger.error("Staff, Alert, and Action Timestamp must be provided");
            throw new IllegalArgumentException("Staff, Alert, and Action Timestamp must be provided");
        }

        logger.info("Saving staff action: staffId={}, alertId={}, timestamp={}",
                action.getStaff().getStaffId(),
                action.getAlert().getAlertId(),
                action.getActionTimestamp());
        return staffTakesActionRepository.save(action);
    }

    /**
     * Delete a staff action by its composite ID.
     *
     * @param id Composite ID consisting of staff ID, alert ID, and action timestamp.
     * @throws ResourceNotFoundException if action is not found.
     */
    @Transactional
    public void deleteAction(StaffTakesActionId id) {
        logger.info("Deleting staff action with ID: {}", id);
        StaffTakesAction action = staffTakesActionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StaffTakesAction not found with ID: " + id));
        staffTakesActionRepository.delete(action);
    }

    /**
     * Retrieve all actions taken by a specific staff member.
     *
     * @param staffId Staff ID.
     * @return List of staff actions.
     */
    public List<StaffTakesAction> getActionsByStaffId(Integer staffId) {
        logger.info("Fetching actions taken by staff ID: {}", staffId);
        return staffTakesActionRepository.findByStaffStaffId(staffId);
    }

    /**
     * Retrieve all actions associated with a specific alert.
     *
     * @param alertId Alert ID.
     * @return List of staff actions.
     */
    public List<StaffTakesAction> getActionsByAlertId(Integer alertId) {
        logger.info("Fetching actions associated with alert ID: {}", alertId);
        return staffTakesActionRepository.findByAlertAlertId(alertId);
    }

    // Additional business logic methods can be added here as needed
}
