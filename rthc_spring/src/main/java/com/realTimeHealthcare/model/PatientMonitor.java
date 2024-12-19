package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "PatientMonitor", schema = "dbo")
//@Table(name = "PatientMonitor")
public class PatientMonitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monitor_id")
    private Integer monitorId;

    @Column(name = "serial_number", unique = true)
    private String serialNumber;

    private String manufacturer;

    @Column(name = "model_number")
    private String modelNumber;

    @Column(name = "last_maintenance_date")
    @Temporal(TemporalType.DATE)
    private Date lastMaintenanceDate;

    @Column(name = "calibration_date")
    @Temporal(TemporalType.DATE)
    private Date calibrationDate;

    private String status;

    // Relationships
    @OneToMany(mappedBy = "monitor")
    private Set<DeviceTypeDefinesMonitor> deviceTypeDefinesMonitors;

    @OneToMany(mappedBy = "monitor")
    private Set<MonitorRecordsVitals> vitalsRecords;

    @OneToMany(mappedBy = "monitor")
    private Set<PatientMonitorAssignment> patientAssignments;

    // Constructors
    public PatientMonitor() {}

    // Getters and Setters

    public Integer getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(Integer monitorId) {
        this.monitorId = monitorId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Date getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(Date lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public Date getCalibrationDate() {
        return calibrationDate;
    }

    public void setCalibrationDate(Date calibrationDate) {
        this.calibrationDate = calibrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<DeviceTypeDefinesMonitor> getDeviceTypeDefinesMonitors() {
        return deviceTypeDefinesMonitors;
    }

    public void setDeviceTypeDefinesMonitors(Set<DeviceTypeDefinesMonitor> deviceTypeDefinesMonitors) {
        this.deviceTypeDefinesMonitors = deviceTypeDefinesMonitors;
    }

    public Set<MonitorRecordsVitals> getVitalsRecords() {
        return vitalsRecords;
    }

    public void setVitalsRecords(Set<MonitorRecordsVitals> vitalsRecords) {
        this.vitalsRecords = vitalsRecords;
    }

    public Set<PatientMonitorAssignment> getPatientAssignments() {
        return patientAssignments;
    }

    public void setPatientAssignments(Set<PatientMonitorAssignment> patientAssignments) {
        this.patientAssignments = patientAssignments;
    }
}
