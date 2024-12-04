// File: src/main/java/com/example/healthcare_system/repository/StaffTakesActionRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.StaffTakesAction;
import com.realTimeHealthcare.model.StaffTakesActionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffTakesActionRepository extends JpaRepository<StaffTakesAction, StaffTakesActionId> {
    // Custom query methods can be added here
}
