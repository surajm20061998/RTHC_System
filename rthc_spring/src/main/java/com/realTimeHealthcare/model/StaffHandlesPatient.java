package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Staff_Handles_Patient", schema = "dbo")
//@Table(name = "Staff_Handles_Patient")
@IdClass(StaffHandlesPatientId.class)
public class StaffHandlesPatient {

    @Id
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @Id
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Id
    @Column(name = "assignment_start_date")
    @Temporal(TemporalType.DATE)
    private Date assignmentStartDate;

    @Column(name = "assignment_end_date")
    @Temporal(TemporalType.DATE)
    private Date assignmentEndDate;

    @Column(name = "care_role")
    private String careRole;

    @Column(name = "shift_schedule")
    private String shiftSchedule;

    // Constructors
    public StaffHandlesPatient() {}

    // Getters and Setters

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getAssignmentStartDate() {
        return assignmentStartDate;
    }

    public void setAssignmentStartDate(Date assignmentStartDate) {
        this.assignmentStartDate = assignmentStartDate;
    }

    public Date getAssignmentEndDate() {
        return assignmentEndDate;
    }

    public void setAssignmentEndDate(Date assignmentEndDate) {
        this.assignmentEndDate = assignmentEndDate;
    }

    public String getCareRole() {
        return careRole;
    }

    public void setCareRole(String careRole) {
        this.careRole = careRole;
    }

    public String getShiftSchedule() {
        return shiftSchedule;
    }

    public void setShiftSchedule(String shiftSchedule) {
        this.shiftSchedule = shiftSchedule;
    }
}
