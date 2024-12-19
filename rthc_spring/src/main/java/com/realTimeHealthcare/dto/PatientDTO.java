// File: src/main/java/com/example/healthcare_system/dto/PatientDTO.java
package com.realTimeHealthcare.dto;

import com.realTimeHealthcare.model.Patient;

/**
 * Data Transfer Object for Patient entity with additional high-risk flag.
 */
public class PatientDTO {
    
    private Patient patient;
    private boolean highRisk;

    // Constructors
    public PatientDTO() {}

    public PatientDTO(Patient patient, boolean highRisk) {
        this.patient = patient;
        this.highRisk = highRisk;
    }

    // Getters and Setters
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public boolean isHighRisk() {
        return highRisk;
    }

    public void setHighRisk(boolean highRisk) {
        this.highRisk = highRisk;
    }
}
