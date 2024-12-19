package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VitalRecords_Triggers_Alert", schema = "dbo")
//@Table(name = "VitalRecords_Triggers_Alert")
@IdClass(VitalRecordsTriggersAlertId.class)
public class VitalRecordsTriggersAlert {

    @Id
    @ManyToOne
    @JoinColumn(name = "record_id")
    private VitalRecord vitalRecord;

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

    // Constructors
    public VitalRecordsTriggersAlert() {}

    // Getters and Setters

    public VitalRecord getVitalRecord() {
        return vitalRecord;
    }

    public void setVitalRecord(VitalRecord vitalRecord) {
        this.vitalRecord = vitalRecord;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    public Double getTriggerThresholdValue() {
        return triggerThresholdValue;
    }

    public void setTriggerThresholdValue(Double triggerThresholdValue) {
        this.triggerThresholdValue = triggerThresholdValue;
    }

    public String getTriggerCondition() {
        return triggerCondition;
    }

    public void setTriggerCondition(String triggerCondition) {
        this.triggerCondition = triggerCondition;
    }

    public Date getTriggerTimestamp() {
        return triggerTimestamp;
    }

    public void setTriggerTimestamp(Date triggerTimestamp) {
        this.triggerTimestamp = triggerTimestamp;
    }
}
