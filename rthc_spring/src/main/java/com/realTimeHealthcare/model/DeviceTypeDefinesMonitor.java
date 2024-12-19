package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DeviceType_Defines_Monitor", schema = "dbo")
//@Table(name = "DeviceType_Defines_Monitor")
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

    // Constructors
    public DeviceTypeDefinesMonitor() {}

    // Getters and Setters

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public PatientMonitor getMonitor() {
        return monitor;
    }

    public void setMonitor(PatientMonitor monitor) {
        this.monitor = monitor;
    }

    public Date getDefinitionDate() {
        return definitionDate;
    }

    public void setDefinitionDate(Date definitionDate) {
        this.definitionDate = definitionDate;
    }

    public Staff getConfiguredByStaff() {
        return configuredByStaff;
    }

    public void setConfiguredByStaff(Staff configuredByStaff) {
        this.configuredByStaff = configuredByStaff;
    }
}
