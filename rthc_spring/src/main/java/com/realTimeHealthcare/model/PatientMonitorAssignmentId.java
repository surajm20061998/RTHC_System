package com.realTimeHealthcare.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PatientMonitorAssignmentId implements Serializable {

    private Integer patient;
    private Integer monitor;
    private Date assignmentDate;

    public PatientMonitorAssignmentId() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientMonitorAssignmentId)) return false;
        PatientMonitorAssignmentId that = (PatientMonitorAssignmentId) o;
        return Objects.equals(patient, that.patient) &&
                Objects.equals(monitor, that.monitor) &&
                Objects.equals(assignmentDate, that.assignmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, monitor, assignmentDate);
    }
}
