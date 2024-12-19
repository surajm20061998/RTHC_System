package com.realTimeHealthcare.model;

import java.io.Serializable;
import java.util.Objects;

public class DeviceTypeDefinesMonitorId implements Serializable {

    private Integer deviceType;
    private Integer monitor;

    public DeviceTypeDefinesMonitorId() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceTypeDefinesMonitorId)) return false;
        DeviceTypeDefinesMonitorId that = (DeviceTypeDefinesMonitorId) o;
        return Objects.equals(deviceType, that.deviceType) &&
                Objects.equals(monitor, that.monitor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceType, monitor);
    }
}
