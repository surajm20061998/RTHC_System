// File: src/main/java/com/example/healthcare_system/repository/StaffHandlesPatientRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.StaffHandlesPatient;
import com.realTimeHealthcare.model.StaffHandlesPatientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffHandlesPatientRepository extends JpaRepository<StaffHandlesPatient, StaffHandlesPatientId> {
    // Find patients handled by a staff member
    List<StaffHandlesPatient> findByStaffStaffId(Integer staffId);

    // Find staff assignments for a patient
    List<StaffHandlesPatient> findByPatientPatientId(Integer patientId);

    // Additional custom query methods can be added here as needed
}
