// File: src/main/java/com/example/healthcare_system/repository/VitalRecordsRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.VitalRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VitalRecordsRepository extends JpaRepository<VitalRecords, Integer> {
    // Find records by timestamp range
    List<VitalRecords> findByTimestampBetween(Date start, Date end);
}
