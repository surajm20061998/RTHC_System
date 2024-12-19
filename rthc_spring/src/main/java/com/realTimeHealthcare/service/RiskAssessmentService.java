package com.realTimeHealthcare.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.realTimeHealthcare.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Map;

@Service
public class RiskAssessmentService {

    @Value("${python.script.path}")
    private String pythonScriptPath;  // e.g., "src/main/resources/scripts/calculate_risk.py"

    @Value("${risk.json.output}")
    private String jsonOutputPath; // e.g., "src/main/resources/static/data/riskFactor.json"

    private final PatientService patientService;
    private final ObjectMapper objectMapper;

    public RiskAssessmentService(PatientService patientService) {
        this.patientService = patientService;
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Runs the Python script to calculate risk factors and risk levels,
     * then updates all matching patients in the database.
     */
    public void runRiskAssessment() throws IOException, InterruptedException {
        // 1. Run the Python script
        ProcessBuilder pb = new ProcessBuilder("python", pythonScriptPath);
        pb.redirectErrorStream(true);
        Process process = pb.start();

        // Read Python script output (for debugging/logging)
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("[Python] " + line);
            }
        }

        int exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println("Python script executed successfully.");
        } else {
            System.out.println("Python script exited with code: " + exitCode);
            // Handle error scenario if needed
        }

        // 2. Parse the JSON output
        File jsonFile = new File(jsonOutputPath);
        if (!jsonFile.exists()) {
            System.err.println("Risk factor JSON file not found at " + jsonOutputPath);
            return;
        }

        // Expected JSON format (example):
        // [
        //   {
        //     "part_id": 1,
        //     "risk_factor": 0.75,
        //     "risk_factor_avg_overall_clinical_visit": 0.5,
        //     "risk_level": "High Risk"
        //   },
        //   ...
        // ]

        List<Map<String, Object>> riskData = objectMapper.readValue(jsonFile, new TypeReference<List<Map<String, Object>>>() {
        });

        // 3. Update patients
        for (Map<String, Object> entry : riskData) {
            Integer partId = ((Number) entry.get("part_id")).intValue();
            Double riskFactor = ((Number) entry.get("risk_factor")).doubleValue();
            String riskLevel = (String) entry.get("risk_level");

            // Fetch the patient by ID (assuming part_id = patientId)
            Patient patient = patientService.getPatientById(partId);
            if (patient != null) {
                patient.setRiskFactor(riskFactor);
                patient.setRiskLevel(riskLevel);
                patientService.savePatient(patient);
            } else {
                System.out.println("No patient found for part_id: " + partId);
            }
        }

        System.out.println("Risk factors and levels updated for patients.");
    }
}

