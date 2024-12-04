package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "VitalRecords")
public class VitalRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;

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

    // Relationships
    @OneToMany(mappedBy = "vitalRecord")
    private Set<MonitorRecordsVitals> monitorRecords;

    @OneToMany(mappedBy = "vitalRecord")
    private Set<PatientHasVitalRecords> patientRecords;

    @OneToMany(mappedBy = "vitalRecord")
    private Set<VitalRecordsTriggersAlert> alertsTriggered;

    // Getters and Setters
    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    // ... [Include other getters and setters]
}
