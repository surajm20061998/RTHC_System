package com.realTimeHealthcare.model;

import java.io.Serializable;
import java.util.Objects;

public class VitalRecordsTriggersAlertId implements Serializable {

    private Integer vitalRecord;
    private Integer alert;

    // Default constructor
    public VitalRecordsTriggersAlertId() {
    }

    // Getters and Setters
    public Integer getVitalRecord() {
        return vitalRecord;
    }

    public void setVitalRecord(Integer vitalRecord) {
        this.vitalRecord = vitalRecord;
    }

    public Integer getAlert() {
        return alert;
    }

    public void setAlert(Integer alert) {
        this.alert = alert;
    }

    // hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(vitalRecord, alert);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof VitalRecordsTriggersAlertId)) return false;
        VitalRecordsTriggersAlertId that = (VitalRecordsTriggersAlertId) obj;
        return Objects.equals(vitalRecord, that.vitalRecord) &&
                Objects.equals(alert, that.alert);
    }
}
