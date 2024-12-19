// File: src/main/java/com/example/healthcare_system/repository/AlertRequiresActionRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.AlertRequiresAction;
import com.realTimeHealthcare.model.AlertRequiresActionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRequiresActionRepository extends JpaRepository<AlertRequiresAction, AlertRequiresActionId> {
    // Additional custom query methods can be added here as needed
}
