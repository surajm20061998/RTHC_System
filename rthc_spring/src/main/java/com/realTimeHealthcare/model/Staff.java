package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String ssn;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(unique = true)
    private String email;

    private String phone;

    private String role;

    private String department;

    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Column(name = "license_number")
    private String licenseNumber;

    private String status;

    // Relationships
    @OneToMany(mappedBy = "primaryPhysician")
    private Set<Patient> patients;

    @OneToMany(mappedBy = "configuredByStaff")
    private Set<DeviceTypeDefinesMonitor> deviceConfigurations;

    @OneToMany(mappedBy = "recordedByStaff")
    private Set<PatientHasVitalRecords> vitalRecords;

    @OneToMany(mappedBy = "staff")
    private Set<StaffTakesAction> actionsTaken;

    @OneToMany(mappedBy = "staff")
    private Set<StaffHandlesPatient> patientAssignments;

    @OneToMany(mappedBy = "assignedByStaff")
    private Set<PatientMonitorAssignment> monitorAssignments;

    // Getters and Setters
    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    // ... [Include other getters and setters]
}
