package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PatientHasVitalRecordsId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "vital_record_id")
    private Integer vitalRecordId;

    // Constructors
    public PatientHasVitalRecordsId() {}

    public PatientHasVitalRecordsId(Integer patientId, Integer vitalRecordId) {
        this.patientId = patientId;
        this.vitalRecordId = vitalRecordId;
    }

    // Getters and Setters

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getVitalRecordId() {
        return vitalRecordId;
    }

    public void setVitalRecordId(Integer vitalRecordId) {
        this.vitalRecordId = vitalRecordId;
    }

    // Override equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientHasVitalRecordsId that = (PatientHasVitalRecordsId) o;

        if (!Objects.equals(patientId, that.patientId)) return false;
        return Objects.equals(vitalRecordId, that.vitalRecordId);
    }

    @Override
    public int hashCode() {
        int result = patientId != null ? patientId.hashCode() : 0;
        result = 31 * result + (vitalRecordId != null ? vitalRecordId.hashCode() : 0);
        return result;
    }
}
