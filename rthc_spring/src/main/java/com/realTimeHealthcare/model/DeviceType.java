package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DeviceType", schema = "dbo")
//@Table(name = "DeviceType")
public class DeviceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deviceType_id")
    private Integer deviceTypeId;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String manufacturer;

    @Column(name = "model_series")
    private String modelSeries;

    @Column(name = "monitoring_capabilities", columnDefinition = "TEXT")
    private String monitoringCapabilities;

    // Relationships
    @OneToMany(mappedBy = "deviceType")
    private Set<DeviceTypeDefinesMonitor> deviceTypeDefinesMonitors;

    // Constructors
    public DeviceType() {}

    // Getters and Setters

    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelSeries() {
        return modelSeries;
    }

    public void setModelSeries(String modelSeries) {
        this.modelSeries = modelSeries;
    }

    public String getMonitoringCapabilities() {
        return monitoringCapabilities;
    }

    public void setMonitoringCapabilities(String monitoringCapabilities) {
        this.monitoringCapabilities = monitoringCapabilities;
    }

    public Set<DeviceTypeDefinesMonitor> getDeviceTypeDefinesMonitors() {
        return deviceTypeDefinesMonitors;
    }

    public void setDeviceTypeDefinesMonitors(Set<DeviceTypeDefinesMonitor> deviceTypeDefinesMonitors) {
        this.deviceTypeDefinesMonitors = deviceTypeDefinesMonitors;
    }
}
