package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Patient", schema = "dbo")
//@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "part_id", unique = true)
    private Integer partId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "ssn", unique = true)
    private String ssn;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "blood_type")
    private String bloodType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "primary_physician_id")
    private Staff primaryPhysician;

    @Column(name = "admission_date")
    @Temporal(TemporalType.DATE)
    private Date admissionDate;

    @Column(name = "discharge_date")
    @Temporal(TemporalType.DATE)
    private Date dischargeDate;

    @Column(name = "status")
    private String status;

    @Column(name = "risk_factor")
    private Double riskFactor;

    @Column(name = "risk_level")
    private String riskLevel;

    // One-to-Many relationship with PatientHasVitalRecords
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PatientHasVitalRecords> patientHasVitalRecords;

    @Transient
    private boolean highRisk;

    @Transient
    private String formattedAdmissionDate;

    // Constructors
    public Patient() {}

    // Getters and Setters

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Staff getPrimaryPhysician() {
        return primaryPhysician;
    }

    public void setPrimaryPhysician(Staff primaryPhysician) {
        this.primaryPhysician = primaryPhysician;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<PatientHasVitalRecords> getPatientHasVitalRecords() {
        return patientHasVitalRecords;
    }

    public void setPatientHasVitalRecords(Set<PatientHasVitalRecords> patientHasVitalRecords) {
        this.patientHasVitalRecords = patientHasVitalRecords;
    }

    public boolean isHighRisk() {
        return highRisk;
    }

    public void setHighRisk(boolean highRisk) {
        this.highRisk = highRisk;
    }

    public Double getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(Double riskFactor) {
        this.riskFactor = riskFactor;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getFormattedAdmissionDate() {
        return formattedAdmissionDate;
    }
    
    public void setFormattedAdmissionDate(String formattedAdmissionDate) {
        this.formattedAdmissionDate = formattedAdmissionDate;
    }
}
