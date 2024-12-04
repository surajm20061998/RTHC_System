package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DeviceType_Defines_Monitor")
@IdClass(DeviceTypeDefinesMonitorId.class)
public class DeviceTypeDefinesMonitor {

    @Id
    @ManyToOne
    @JoinColumn(name = "deviceType_id")
    private DeviceType deviceType;

    @Id
    @ManyToOne
    @JoinColumn(name = "monitor_id")
    private PatientMonitor monitor;

    @Column(name = "definition_date")
    @Temporal(TemporalType.DATE)
    private Date definitionDate;

    @ManyToOne
    @JoinColumn(name = "configured_by_staff_id")
    private Staff configuredByStaff;

    // Getters and Setters
    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    // ... [Include other getters and setters]
}
