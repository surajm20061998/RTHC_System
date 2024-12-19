package com.realTimeHealthcare.service;

import com.realTimeHealthcare.model.VitalRecord;
import com.realTimeHealthcare.repository.VitalRecordsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VitalRecordsService {

    private final VitalRecordsRepository vitalRecordsRepository;

    public VitalRecordsService(VitalRecordsRepository vitalRecordsRepository) {
        this.vitalRecordsRepository = vitalRecordsRepository;
    }

    /**
     * Retrieve the latest vital records for all patients.
     *
     * @return List of latest VitalRecords for each patient.
     */
    @Transactional(readOnly = true)
    public List<VitalRecord> getLatestVitalRecordsForAllPatients() {
        return vitalRecordsRepository.findLatestVitalRecordsForAllPatients();
    }
}
