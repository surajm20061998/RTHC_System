// File: src/main/java/com/example/healthcare_system/repository/StaffRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    // Find staff by email
    Staff findByEmail(String email);

    // Find staff by role
    List<Staff> findByRole(String role);

    // Find staff by department
    List<Staff> findByDepartment(String department);

    // Find staff by status
    List<Staff> findByStatus(String status);

    @Query("SELECT s FROM Staff s WHERE s.onDutyDate = CURRENT_DATE")
    List<Staff> findStaffWorkingToday();
}
