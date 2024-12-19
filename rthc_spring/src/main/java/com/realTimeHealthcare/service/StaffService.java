// File: src/main/java/com/example/healthcare_system/service/StaffService.java
package com.realTimeHealthcare.service;

import com.realTimeHealthcare.exception.ResourceNotFoundException;
import com.realTimeHealthcare.model.Staff;
import com.realTimeHealthcare.repository.StaffRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffService {

    private static final Logger logger = LoggerFactory.getLogger(StaffService.class);

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    /**
     * Retrieve all staff members.
     *
     * @return List of all staff.
     */
    public List<Staff> getAllStaff() {
        logger.info("Fetching all staff members");
        return staffRepository.findAll();
    }

    /**
     * Retrieve a staff member by their ID.
     *
     * @param id Staff ID.
     * @return Staff object.
     * @throws ResourceNotFoundException if staff member is not found.
     */
    public Staff getStaffById(Integer id) {
        logger.info("Fetching staff member with ID: {}", id);
        return staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff not found with ID: " + id));
    }

    /**
     * Create or update a staff member.
     *
     * @param staff Staff object to save.
     * @return Saved Staff.
     */
    @Transactional
    public Staff saveStaff(Staff staff) {
        if (staff.getStaffId() == null) {
            logger.info("Creating new staff member");
        } else {
            logger.info("Updating staff member with ID: {}", staff.getStaffId());
        }

        // Optional: Add validation logic here (e.g., check mandatory fields)

        return staffRepository.save(staff);
    }

    /**
     * Delete a staff member by their ID.
     *
     * @param id Staff ID.
     * @throws ResourceNotFoundException if staff member is not found.
     */
    @Transactional
    public void deleteStaff(Integer id) {
        logger.info("Deleting staff member with ID: {}", id);
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff not found with ID: " + id));
        staffRepository.delete(staff);
    }

    /**
     * Retrieve a staff member by their email.
     *
     * @param email Staff email.
     * @return Staff object.
     * @throws ResourceNotFoundException if staff member is not found.
     */
    public Staff getStaffByEmail(String email) {
        logger.info("Fetching staff member with email: {}", email);
        Staff staff = staffRepository.findByEmail(email);
        if (staff == null) {
            throw new ResourceNotFoundException("Staff not found with email: " + email);
        }
        return staff;
    }

    /**
     * Retrieve staff members by their role.
     *
     * @param role Role of staff members.
     * @return List of staff matching the role.
     */
    public List<Staff> getStaffByRole(String role) {
        logger.info("Fetching staff members with role: {}", role);
        return staffRepository.findByRole(role);
    }

    /**
     * Retrieve staff members by department.
     *
     * @param department Department name.
     * @return List of staff in the specified department.
     */
    public List<Staff> getStaffByDepartment(String department) {
        logger.info("Fetching staff members in department: {}", department);
        return staffRepository.findByDepartment(department);
    }

    /**
     * Retrieve staff members by status.
     *
     * @param status Employment status.
     * @return List of staff matching the status.
     */
    public List<Staff> getStaffByStatus(String status) {
        logger.info("Fetching staff members with status: {}", status);
        return staffRepository.findByStatus(status);
    }

    public List<Staff> getStaffWorkingToday() {
        return staffRepository.findStaffWorkingToday();
    }
}
