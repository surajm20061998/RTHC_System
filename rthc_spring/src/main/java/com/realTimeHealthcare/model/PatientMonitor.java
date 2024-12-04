package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "PatientMonitor")
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
    private Set<DeviceTypeDefinesMonitor> deviceTypeDefinitions;

    @OneToMany(mappedBy = "monitor")
    private Set<MonitorRecordsVitals> vitalsRecords;

    @OneToMany(mappedBy = "monitor")
    private Set<PatientMonitorAssignment> patientAssignments;

    // Getters and Setters
    public Integer getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(Integer monitorId) {
        this.monitorId = monitorId;
    }

    // ... [Include other getters and setters]
}
