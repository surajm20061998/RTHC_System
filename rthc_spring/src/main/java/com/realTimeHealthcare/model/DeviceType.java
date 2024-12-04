package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DeviceType")
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

    // ... [Include other getters and setters]
}

