package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PatientMonitorAssignment")
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

    // Getters and Setters
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // ... [Include other getters and setters]
}
