package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Staff_Handles_Patient")
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

    // Getters and Setters
    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    // ... [Include other getters and setters]
}
