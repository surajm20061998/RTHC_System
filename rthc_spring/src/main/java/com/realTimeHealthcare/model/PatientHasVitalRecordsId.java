// File: src/main/java/com/example/healthcare_system/model/PatientHasVitalRecordsId.java
package com.realTimeHealthcare.model;

import java.io.Serializable;
import java.util.Objects;

public class PatientHasVitalRecordsId implements Serializable {

    private Integer patient;
    private Integer vitalRecord;

    // Default constructor
    public PatientHasVitalRecordsId() {
    }

    // Getters and Setters
    public Integer getPatient() {
        return patient;
    }

    public void setPatient(Integer patient) {
        this.patient = patient;
    }

    public Integer getVitalRecord() {
        return vitalRecord;
    }

    public void setVitalRecord(Integer vitalRecord) {
        this.vitalRecord = vitalRecord;
    }

    // hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(patient, vitalRecord);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PatientHasVitalRecordsId)) return false;
        PatientHasVitalRecordsId that = (PatientHasVitalRecordsId) obj;
        return Objects.equals(patient, that.patient) &&
                Objects.equals(vitalRecord, that.vitalRecord);
    }
}
