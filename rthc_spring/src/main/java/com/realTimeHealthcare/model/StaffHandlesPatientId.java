package com.realTimeHealthcare.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class StaffHandlesPatientId implements Serializable {

    private Integer staff;
    private Integer patient;
    private Date assignmentStartDate;

    // Default constructor
    public StaffHandlesPatientId() {
    }

    // Getters and Setters
    public Integer getStaff() {
        return staff;
    }

    public void setStaff(Integer staff) {
        this.staff = staff;
    }

    public Integer getPatient() {
        return patient;
    }

    public void setPatient(Integer patient) {
        this.patient = patient;
    }

    public Date getAssignmentStartDate() {
        return assignmentStartDate;
    }

    public void setAssignmentStartDate(Date assignmentStartDate) {
        this.assignmentStartDate = assignmentStartDate;
    }

    // hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(staff, patient, assignmentStartDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StaffHandlesPatientId)) return false;
        StaffHandlesPatientId that = (StaffHandlesPatientId) obj;
        return Objects.equals(staff, that.staff) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(assignmentStartDate, that.assignmentStartDate);
    }
}
