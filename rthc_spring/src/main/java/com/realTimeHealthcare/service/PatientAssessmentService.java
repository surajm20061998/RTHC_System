package com.realTimeHealthcare.service;

import com.realTimeHealthcare.model.PatientAssessment;
import com.realTimeHealthcare.repository.PatientAssessmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientAssessmentService {

    private final PatientAssessmentRepository patientAssessmentRepository;

    public PatientAssessmentService(PatientAssessmentRepository patientAssessmentRepository) {
        this.patientAssessmentRepository = patientAssessmentRepository;
    }

    /**
     * Get all assessments for a given patient ID.
     *
     * @param patientId the ID of the patient.
     * @return a list of PatientAssessment objects
     */
    public List<PatientAssessment> getAssessmentsForPatient(Integer patientId) {
        return patientAssessmentRepository.findByPatient_PatientId(patientId);
    }

    /**
     * Get a specific assessment by its ID.
     *
     * @param assessmentId The ID of the assessment.
     * @return PatientAssessment object if found, else null.
     */
    public PatientAssessment getAssessmentById(Integer assessmentId) {
        return patientAssessmentRepository.findById(assessmentId).orElse(null);
    }

    /**
     * Save or update an assessment.
     *
     * @param assessment the PatientAssessment to save or update.
     * @return the persisted PatientAssessment object.
     */
    public PatientAssessment saveOrUpdate(PatientAssessment assessment) {
        return patientAssessmentRepository.save(assessment);
    }

    /**
     * Delete an assessment by ID.
     *
     * @param assessmentId the ID of the assessment to delete.
     */
    public void deleteAssessment(Integer assessmentId) {
        patientAssessmentRepository.deleteById(assessmentId);
    }
}
