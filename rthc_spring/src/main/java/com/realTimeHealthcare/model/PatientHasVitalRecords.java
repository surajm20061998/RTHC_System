// File: src/main/java/com/example/healthcare_system/model/PatientHasVitalRecords.java
package com.realTimeHealthcare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Patient_Has_VitalRecords")
@IdClass(PatientHasVitalRecordsId.class)
public class PatientHasVitalRecords {

    @Id
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Id
    @ManyToOne
    @JoinColumn(name = "record_id")
    private VitalRecords vitalRecord;

    @ManyToOne
    @JoinColumn(name = "recorded_by_staff_id")
    private Staff recordedByStaff;

    @Column(name = "recording_session_id")
    private String recordingSessionId;

    // Getters and Setters
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // ... [Include other getters and setters]
}
