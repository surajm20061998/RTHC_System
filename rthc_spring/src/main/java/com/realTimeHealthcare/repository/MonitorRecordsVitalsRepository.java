package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.MonitorRecordsVitals;
import com.realTimeHealthcare.model.MonitorRecordsVitalsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRecordsVitalsRepository extends JpaRepository<MonitorRecordsVitals, MonitorRecordsVitalsId> {
    // Custom query methods can be added here
}
