// File: src/main/java/com/example/healthcare_system/repository/StaffHandlesPatientRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.StaffHandlesPatient;
import com.realTimeHealthcare.model.StaffHandlesPatientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface StaffHandlesPatientRepository extends JpaRepository<StaffHandlesPatient, StaffHandlesPatientId> {
    // Find patients handled by a staff member
    List<StaffHandlesPatient> findByStaffStaffId(Integer staffId);
}
