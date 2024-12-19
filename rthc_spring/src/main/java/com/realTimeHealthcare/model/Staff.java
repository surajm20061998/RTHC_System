package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Staff", schema = "dbo")
//@Table(name = "Staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "ssn", unique = true)
    private String ssn;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "onDutyDate")
    @Temporal(TemporalType.DATE) // Use this if using java.util.Date
    private Date onDutyDate;

    @Column(name = "email", unique = true)
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
    @OneToMany(mappedBy = "primaryPhysician", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Patient> patients;

    @OneToMany(mappedBy = "configuredByStaff", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DeviceTypeDefinesMonitor> deviceConfigurations;

    @OneToMany(mappedBy = "recordedByStaff", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PatientHasVitalRecords> vitalRecords;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<StaffTakesAction> actionsTaken;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<StaffHandlesPatient> patientAssignments;

    @OneToMany(mappedBy = "assignedByStaff", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PatientMonitorAssignment> monitorAssignments;

    // Constructors
    public Staff() {}

    // Getters and Setters

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public Set<DeviceTypeDefinesMonitor> getDeviceConfigurations() {
        return deviceConfigurations;
    }

    public void setDeviceConfigurations(Set<DeviceTypeDefinesMonitor> deviceConfigurations) {
        this.deviceConfigurations = deviceConfigurations;
    }

    public Set<PatientHasVitalRecords> getVitalRecords() {
        return vitalRecords;
    }

    public void setVitalRecords(Set<PatientHasVitalRecords> vitalRecords) {
        this.vitalRecords = vitalRecords;
    }

    public Set<StaffTakesAction> getActionsTaken() {
        return actionsTaken;
    }

    public void setActionsTaken(Set<StaffTakesAction> actionsTaken) {
        this.actionsTaken = actionsTaken;
    }

    public Set<StaffHandlesPatient> getPatientAssignments() {
        return patientAssignments;
    }

    public void setPatientAssignments(Set<StaffHandlesPatient> patientAssignments) {
        this.patientAssignments = patientAssignments;
    }

    public Set<PatientMonitorAssignment> getMonitorAssignments() {
        return monitorAssignments;
    }

    public void setMonitorAssignments(Set<PatientMonitorAssignment> monitorAssignments) {
        this.monitorAssignments = monitorAssignments;
    }

    public Date getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Date onDutyDate) {
        this.onDutyDate = onDutyDate;
    }
}
