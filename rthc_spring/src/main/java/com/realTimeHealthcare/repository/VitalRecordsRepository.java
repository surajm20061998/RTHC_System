package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.VitalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VitalRecordsRepository extends JpaRepository<VitalRecord, Integer> {
    
    /**
     * Find VitalRecords by Patient ID and Temperature greater than a specified value.
     *
     * @param patientId   ID of the patient.
     * @param temperature Temperature threshold.
     * @return List of VitalRecords matching the criteria.
     */
    List<VitalRecord> findByPatientHasVitalRecords_Patient_PatientIdAndTemperatureGreaterThan(Integer patientId, Double temperature);
    
    /**
     * Custom query to fetch the latest VitalRecord for each patient.
     *
     * @return List of latest VitalRecords for all patients.
     */
    @Query("SELECT vr FROM VitalRecord vr " +
       "JOIN vr.patientHasVitalRecords phvr " +
       "JOIN phvr.patient p " +
       "WHERE vr.timestamp = (" +
       "  SELECT MAX(vr2.timestamp) FROM VitalRecord vr2 " +
       "  JOIN vr2.patientHasVitalRecords phvr2 " +
       "  JOIN phvr2.patient p2 " +
       "  WHERE p2 = p" +
       ")")
    List<VitalRecord> findLatestVitalRecordsForAllPatients();
}
