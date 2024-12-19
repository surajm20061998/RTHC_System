package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Monitor_Records_Vitals", schema = "dbo")
//@Table(name = "Monitor_Records_Vitals")
@IdClass(MonitorRecordsVitalsId.class)
public class MonitorRecordsVitals {

    @Id
    @ManyToOne
    @JoinColumn(name = "monitor_id")
    private PatientMonitor monitor;

    @Id
    @ManyToOne
    @JoinColumn(name = "record_id")
    private VitalRecord vitalRecord;

    @Column(name = "recording_start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordingStartTime;

    @Column(name = "recording_end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordingEndTime;

    @Column(name = "data_quality_score")
    private Double dataQualityScore;

    // Constructors
    public MonitorRecordsVitals() {}

    // Getters and Setters

    public PatientMonitor getMonitor() {
        return monitor;
    }

    public void setMonitor(PatientMonitor monitor) {
        this.monitor = monitor;
    }

    public VitalRecord getVitalRecord() {
        return vitalRecord;
    }

    public void setVitalRecord(VitalRecord vitalRecord) {
        this.vitalRecord = vitalRecord;
    }

    public Date getRecordingStartTime() {
        return recordingStartTime;
    }

    public void setRecordingStartTime(Date recordingStartTime) {
        this.recordingStartTime = recordingStartTime;
    }

    public Date getRecordingEndTime() {
        return recordingEndTime;
    }

    public void setRecordingEndTime(Date recordingEndTime) {
        this.recordingEndTime = recordingEndTime;
    }

    public Double getDataQualityScore() {
        return dataQualityScore;
    }

    public void setDataQualityScore(Double dataQualityScore) {
        this.dataQualityScore = dataQualityScore;
    }
}
