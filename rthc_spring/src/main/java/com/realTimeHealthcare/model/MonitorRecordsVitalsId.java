package com.realTimeHealthcare.model;

import java.io.Serializable;
import java.util.Objects;

public class MonitorRecordsVitalsId implements Serializable {

    private Integer monitor;
    private Integer vitalRecord;

    // Default constructor
    public MonitorRecordsVitalsId() {
    }

    // Getters and Setters
    public Integer getMonitor() {
        return monitor;
    }

    public void setMonitor(Integer monitor) {
        this.monitor = monitor;
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
        return Objects.hash(monitor, vitalRecord);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MonitorRecordsVitalsId)) return false;
        MonitorRecordsVitalsId that = (MonitorRecordsVitalsId) obj;
        return Objects.equals(monitor, that.monitor) &&
                Objects.equals(vitalRecord, that.vitalRecord);
    }
}
