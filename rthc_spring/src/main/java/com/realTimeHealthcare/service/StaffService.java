// File: src/main/java/com/example/healthcare_system/service/StaffService.java
package com.realTimeHealthcare.service;

import com.realTimeHealthcare.model.Staff;
import com.realTimeHealthcare.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    // Get all staff members
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    // Get staff by ID
    public Staff getStaffById(Integer id) {
        return staffRepository.findById(id).orElse(null);
    }

    // Add or update staff
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    // Delete staff
    public void deleteStaff(Integer id) {
        staffRepository.deleteById(id);
    }

    // Custom methods
    public Staff getStaffByEmail(String email) {
        return staffRepository.findByEmail(email);
    }

    public List<Staff> getStaffByRole(String role) {
        return staffRepository.findByRole(role);
    }
}
