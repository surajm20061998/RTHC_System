package com.realTimeHealthcare.model;

import java.io.Serializable;
import java.util.Objects;

public class VitalRecordsTriggersAlertId implements Serializable {

    private Integer vitalRecord;
    private Integer alert;

    public VitalRecordsTriggersAlertId() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VitalRecordsTriggersAlertId)) return false;
        VitalRecordsTriggersAlertId that = (VitalRecordsTriggersAlertId) o;
        return Objects.equals(vitalRecord, that.vitalRecord) &&
                Objects.equals(alert, that.alert);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vitalRecord, alert);
    }
}
