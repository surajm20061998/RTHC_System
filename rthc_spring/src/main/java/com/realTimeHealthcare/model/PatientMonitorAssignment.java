package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PatientMonitorAssignment", schema = "dbo")
//@Table(name = "PatientMonitorAssignment")
@IdClass(PatientMonitorAssignmentId.class)
public class PatientMonitorAssignment {

    @Id
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Id
    @ManyToOne
    @JoinColumn(name = "monitor_id")
    private PatientMonitor monitor;

    @Id
    @Column(name = "assignment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assignmentDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "assigned_by_staff_id")
    private Staff assignedByStaff;

    @Column(name = "monitoring_protocol_id")
    private String monitoringProtocolId;

    // Constructors
    public PatientMonitorAssignment() {}

    // Getters and Setters

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientMonitor getMonitor() {
        return monitor;
    }

    public void setMonitor(PatientMonitor monitor) {
        this.monitor = monitor;
    }

    public Date getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Staff getAssignedByStaff() {
        return assignedByStaff;
    }

    public void setAssignedByStaff(Staff assignedByStaff) {
        this.assignedByStaff = assignedByStaff;
    }

    public String getMonitoringProtocolId() {
        return monitoringProtocolId;
    }

    public void setMonitoringProtocolId(String monitoringProtocolId) {
        this.monitoringProtocolId = monitoringProtocolId;
    }
}
