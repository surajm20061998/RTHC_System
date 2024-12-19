// File: src/main/java/com/example/healthcare_system/repository/VitalRecordsTriggersAlertRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.VitalRecordsTriggersAlert;
import com.realTimeHealthcare.model.VitalRecordsTriggersAlertId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VitalRecordsTriggersAlertRepository extends JpaRepository<VitalRecordsTriggersAlert, VitalRecordsTriggersAlertId> {
    // Additional custom query methods can be added here as needed
}
