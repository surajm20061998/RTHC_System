package com.realTimeHealthcare.model;

import java.io.Serializable;
import java.util.Objects;

public class MonitorRecordsVitalsId implements Serializable {

    private Integer monitor;
    private Integer vitalRecord;

    public MonitorRecordsVitalsId() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonitorRecordsVitalsId)) return false;
        MonitorRecordsVitalsId that = (MonitorRecordsVitalsId) o;
        return Objects.equals(monitor, that.monitor) &&
                Objects.equals(vitalRecord, that.vitalRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monitor, vitalRecord);
    }
}
