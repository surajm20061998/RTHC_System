package com.realTimeHealthcare.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PatientMonitorAssignmentId implements Serializable {

    private Integer patient;
    private Integer monitor;
    private Date assignmentDate;

    // Default constructor
    public PatientMonitorAssignmentId() {
    }

    // Getters and Setters
    public Integer getPatient() {
        return patient;
    }

    public void setPatient(Integer patient) {
        this.patient = patient;
    }

    public Integer getMonitor() {
        return monitor;
    }

    public void setMonitor(Integer monitor) {
        this.monitor = monitor;
    }

    public Date getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    // hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(patient, monitor, assignmentDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PatientMonitorAssignmentId)) return false;
        PatientMonitorAssignmentId that = (PatientMonitorAssignmentId) obj;
        return Objects.equals(patient, that.patient) &&
                Objects.equals(monitor, that.monitor) &&
                Objects.equals(assignmentDate, that.assignmentDate);
    }
}
