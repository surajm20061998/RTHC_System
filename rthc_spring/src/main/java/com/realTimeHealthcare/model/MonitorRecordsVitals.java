package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Monitor_Records_Vitals")
@IdClass(MonitorRecordsVitalsId.class)
public class MonitorRecordsVitals {

    @Id
    @ManyToOne
    @JoinColumn(name = "monitor_id")
    private PatientMonitor monitor;

    @Id
    @ManyToOne
    @JoinColumn(name = "record_id")
    private VitalRecords vitalRecord;

    @Column(name = "recording_start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordingStartTime;

    @Column(name = "recording_end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordingEndTime;

    @Column(name = "data_quality_score")
    private Double dataQualityScore;

    // Getters and Setters
    public PatientMonitor getMonitor() {
        return monitor;
    }

    public void setMonitor(PatientMonitor monitor) {
        this.monitor = monitor;
    }

    // ... [Include other getters and setters]
}
