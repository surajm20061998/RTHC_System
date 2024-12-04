package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String ssn;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private String gender;

    @Column(name = "blood_type")
    private String bloodType;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "primary_physician_id")
    private Staff primaryPhysician;

    @Column(name = "admission_date")
    @Temporal(TemporalType.DATE)
    private Date admissionDate;

    @Column(name = "discharge_date")
    @Temporal(TemporalType.DATE)
    private Date dischargeDate;

    private String status;

    @OneToMany(mappedBy = "patient")
    private Set<PatientHasVitalRecords> vitalRecords;

    @OneToMany(mappedBy = "patient")
    private Set<StaffHandlesPatient> staffAssignments;

    @OneToMany(mappedBy = "patient")
    private Set<PatientMonitorAssignment> monitorAssignments;

    // Getters and Setters
    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    // ... [Include other getters and setters]
}
