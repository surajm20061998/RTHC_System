package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "VitalRecords", schema = "dbo")
//@Table(name = "VitalRecords")
public class VitalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer vitalRecordId;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Column(name = "heart_rate")
    private Integer heartRate;

    @Column(name = "blood_pressure_systolic")
    private Integer bloodPressureSystolic;

    @Column(name = "blood_pressure_diastolic")
    private Integer bloodPressureDiastolic;

    private Double temperature;

    @Column(name = "respiratory_rate")
    private Integer respiratoryRate;

    @Column(name = "oxygen_saturation")
    private Integer oxygenSaturation;

    // One-to-Many relationship with PatientHasVitalRecords
    @OneToMany(mappedBy = "vitalRecord", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PatientHasVitalRecords> patientHasVitalRecords;

    // NEW: ManyToOne relationship with Patient
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "patient_id", nullable = false)
    // private Patient patient;

    // Constructors
    public VitalRecord() {}

    // Getters and Setters

    public Integer getVitalRecordId() {
        return vitalRecordId;
    }

    public void setVitalRecordId(Integer vitalRecordId) {
        this.vitalRecordId = vitalRecordId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Integer getBloodPressureSystolic() {
        return bloodPressureSystolic;
    }

    public void setBloodPressureSystolic(Integer bloodPressureSystolic) {
        this.bloodPressureSystolic = bloodPressureSystolic;
    }

    public Integer getBloodPressureDiastolic() {
        return bloodPressureDiastolic;
    }

    public void setBloodPressureDiastolic(Integer bloodPressureDiastolic) {
        this.bloodPressureDiastolic = bloodPressureDiastolic;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(Integer respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public Integer getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(Integer oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }

    public Set<PatientHasVitalRecords> getPatientHasVitalRecords() {
        return patientHasVitalRecords;
    }

    public void setPatientHasVitalRecords(Set<PatientHasVitalRecords> patientHasVitalRecords) {
        this.patientHasVitalRecords = patientHasVitalRecords;
    }

    // public Patient getPatient() {
    //     return patient;
    // }

    // public void setPatient(Patient patient) {
    //     this.patient = patient;
    // }

    // Other getters and setters...
}
