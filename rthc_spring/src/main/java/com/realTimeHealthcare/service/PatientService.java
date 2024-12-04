// File: src/main/java/com/example/healthcare_system/service/PatientService.java
package com.realTimeHealthcare.service;

import com.realTimeHealthcare.model.Patient;
import com.realTimeHealthcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get patient by ID
    public Patient getPatientById(Integer id) {
        return patientRepository.findById(id).orElse(null);
    }

    // Add or update patient
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Delete patient
    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }

    // Custom methods
    public List<Patient> getPatientsByStatus(String status) {
        return patientRepository.findByStatus(status);
    }

    public List<Patient> getPatientsAdmittedAfter(Date date) {
        return patientRepository.findByAdmissionDateAfter(date);
    }
}
