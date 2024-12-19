package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Patient_Has_VitalRecords", schema = "dbo")
//@Table(name = "Patient_Has_VitalRecords")
public class PatientHasVitalRecords implements Serializable {

    @EmbeddedId
    private PatientHasVitalRecordsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("patientId")
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("vitalRecordId")
    @JoinColumn(name = "record_id")
    private VitalRecord vitalRecord;

    /**
     * New Relationship: Each PatientHasVitalRecords is recorded by a Staff member.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recorded_by_staff_id", nullable = false)
    private Staff recordedByStaff;

    // Constructors
    public PatientHasVitalRecords() {}

    public PatientHasVitalRecords(PatientHasVitalRecordsId id, Patient patient, VitalRecord vitalRecord, Staff recordedByStaff) {
        this.id = id;
        this.patient = patient;
        this.vitalRecord = vitalRecord;
        this.recordedByStaff = recordedByStaff;
    }

    // Getters and Setters

    public PatientHasVitalRecordsId getId() {
        return id;
    }

    public void setId(PatientHasVitalRecordsId id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public VitalRecord getVitalRecord() {
        return vitalRecord;
    }

    public void setVitalRecord(VitalRecord vitalRecord) {
        this.vitalRecord = vitalRecord;
    }

    public Staff getRecordedByStaff() {
        return recordedByStaff;
    }

    public void setRecordedByStaff(Staff recordedByStaff) {
        this.recordedByStaff = recordedByStaff;
    }
}
