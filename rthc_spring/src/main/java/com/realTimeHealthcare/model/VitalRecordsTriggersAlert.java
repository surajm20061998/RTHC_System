package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VitalRecords_Triggers_Alert")
@IdClass(VitalRecordsTriggersAlertId.class)
public class VitalRecordsTriggersAlert {

    @Id
    @ManyToOne
    @JoinColumn(name = "record_id")
    private VitalRecords vitalRecord;

    @Id
    @ManyToOne
    @JoinColumn(name = "alert_id")
    private Alert alert;

    @Column(name = "trigger_threshold_value")
    private Double triggerThresholdValue;

    @Column(name = "trigger_condition")
    private String triggerCondition;

    @Column(name = "trigger_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date triggerTimestamp;

    // Getters and Setters
    public VitalRecords getVitalRecord() {
        return vitalRecord;
    }

    public void setVitalRecord(VitalRecords vitalRecord) {
        this.vitalRecord = vitalRecord;
    }

    // ... [Include other getters and setters]
}
