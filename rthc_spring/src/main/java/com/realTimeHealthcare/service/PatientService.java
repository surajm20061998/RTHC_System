// File: src/main/java/com/example/healthcare_system/service/PatientService.java
package com.realTimeHealthcare.service;

import com.realTimeHealthcare.exception.ResourceNotFoundException;
import com.realTimeHealthcare.model.Patient;
import com.realTimeHealthcare.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Retrieve all patients.
     *
     * @return List of all patients.
     */
    public List<Patient> getAllPatients() {
        logger.info("Fetching all patients");
        return patientRepository.findAll();
    }

    /**
     * Retrieve a patient by its ID.
     *
     * @param id Patient ID.
     * @return Patient object.
     * @throws ResourceNotFoundException if patient is not found.
     */
    public Patient getPatientById(Integer id) {
        logger.info("Fetching patient with ID: {}", id);
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + id));
    }

    /**
     * Create or update a patient.
     *
     * @param patient Patient object to save.
     * @return Saved Patient.
     */
    @Transactional
    public Patient savePatient(Patient patient) {
        if (patient.getPatientId() == null) {
            logger.info("Creating new patient");
        } else {
            logger.info("Updating patient with ID: {}", patient.getPatientId());
        }

        // Optional: Add validation logic here (e.g., check mandatory fields)

        return patientRepository.save(patient);
    }

    /**
     * Delete a patient by its ID.
     *
     * @param id Patient ID.
     * @throws ResourceNotFoundException if patient is not found.
     */
    @Transactional
    public void deletePatient(Integer id) {
        logger.info("Deleting patient with ID: {}", id);
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + id));
        patientRepository.delete(patient);
    }

    /**
     * Retrieve patients by status.
     *
     * @param status Status of patients.
     * @return List of patients matching the status.
     */
    public List<Patient> getPatientsByStatus(String status) {
        logger.info("Fetching patients with status: {}", status);
        return patientRepository.findByStatus(status);
    }

    /**
     * Retrieve patients admitted after a specific date.
     *
     * @param date Admission date threshold.
     * @return List of patients admitted after the specified date.
     */
    public List<Patient> getPatientsAdmittedAfter(Date date) {
        logger.info("Fetching patients admitted after: {}", date);
        return patientRepository.findByAdmissionDateAfter(date);
    }

    /**
     * Retrieve patients by primary physician ID.
     *
     * @param physicianId Primary physician's staff ID.
     * @return List of patients assigned to the specified physician.
     */
    public List<Patient> getPatientsByPrimaryPhysician(Integer physicianId) {
        logger.info("Fetching patients assigned to physician ID: {}", physicianId);
        return patientRepository.findByPrimaryPhysicianStaffId(physicianId);
    }

    /**
     * Retrieve patients by blood type.
     *
     * @param bloodType Blood type of patients.
     * @return List of patients matching the blood type.
     */
    public List<Patient> getPatientsByBloodType(String bloodType) {
        logger.info("Fetching patients with blood type: {}", bloodType);
        return patientRepository.findByBloodType(bloodType);
    }

    /**
     * Retrieve patients by gender.
     *
     * @param gender Gender of patients.
     * @return List of patients matching the gender.
     */
    public List<Patient> getPatientsByGender(String gender) {
        logger.info("Fetching patients with gender: {}", gender);
        return patientRepository.findByGender(gender);
    }

    /**
     * Retrieve patients with their vital records using EntityGraph for optimized fetching.
     *
     * @return List of patients with their vital records.
     */
    public List<Patient> getAllPatientsWithVitalRecords() {
        logger.info("Fetching all patients with their vital records");
        return patientRepository.findAll(); // @EntityGraph applied in repository
    }

    public List<Patient> getPatientsArrivingToday() {
        return patientRepository.findPatientsArrivingToday();
    }

    public List<Patient> getHighRiskPatients() {
        return patientRepository.findHighRiskPatients();
    }

    public Patient getPatientByPartId(Integer partId) {
        return patientRepository.findByPartId(partId);
    }
}
