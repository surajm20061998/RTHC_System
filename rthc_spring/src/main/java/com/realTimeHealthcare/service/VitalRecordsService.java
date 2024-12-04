// File: src/main/java/com/example/healthcare_system/service/VitalRecordsService.java
package com.realTimeHealthcare.service;

import com.realTimeHealthcare.model.VitalRecords;
import com.realTimeHealthcare.repository.VitalRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VitalRecordsService {

    @Autowired
    private VitalRecordsRepository vitalRecordsRepository;

    // Get all vital records
    public List<VitalRecords> getAllVitalRecords() {
        return vitalRecordsRepository.findAll();
    }

    // Get vital record by ID
    public VitalRecords getVitalRecordById(Integer id) {
        return vitalRecordsRepository.findById(id).orElse(null);
    }

    // Add or update vital record
    public VitalRecords saveVitalRecord(VitalRecords vitalRecord) {
        return vitalRecordsRepository.save(vitalRecord);
    }

    // Delete vital record
    public void deleteVitalRecord(Integer id) {
        vitalRecordsRepository.deleteById(id);
    }

    // Custom methods
    public List<VitalRecords> getVitalRecordsBetween(Date start, Date end) {
        return vitalRecordsRepository.findByTimestampBetween(start, end);
    }
}
