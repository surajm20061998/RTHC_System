package com.realTimeHealthcare.model;

import java.io.Serializable;
import java.util.Objects;

public class DeviceTypeDefinesMonitorId implements Serializable {

    private Integer deviceType;
    private Integer monitor;

    // Default constructor
    public DeviceTypeDefinesMonitorId() {
    }

    // Getters and Setters
    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getMonitor() {
        return monitor;
    }

    public void setMonitor(Integer monitor) {
        this.monitor = monitor;
    }

    // hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(deviceType, monitor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DeviceTypeDefinesMonitorId)) return false;
        DeviceTypeDefinesMonitorId that = (DeviceTypeDefinesMonitorId) obj;
        return Objects.equals(deviceType, that.deviceType) &&
                Objects.equals(monitor, that.monitor);
    }
}
