package com.realTimeHealthcare.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realTimeHealthcare.dto.PatientDTO;
import com.realTimeHealthcare.model.Alert;
import com.realTimeHealthcare.model.Patient;
import com.realTimeHealthcare.model.PatientAssessment;
import com.realTimeHealthcare.model.Staff;
import com.realTimeHealthcare.model.VitalRecord;
import com.realTimeHealthcare.service.AlertService;
import com.realTimeHealthcare.service.PatientService;
import com.realTimeHealthcare.service.StaffService;
import com.realTimeHealthcare.service.VitalRecordsService;
import com.realTimeHealthcare.service.ForecastService;
import com.realTimeHealthcare.service.PatientAssessmentService;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Date;



@Controller
public class WebController {

    private final PatientService patientService;
    private final StaffService staffService;
    private final AlertService alertService;
    private final VitalRecordsService vitalRecordService;
    private final ForecastService forecastService;
    private PatientAssessmentService patientAssessmentService;

    // Define your health stat thresholds
    private final int HEART_RATE_THRESHOLD = 100; // Example threshold
    private final double TEMPERATURE_THRESHOLD = 38.0; // Example threshold
    // Add more thresholds as needed

    // Constructor-based Dependency Injection
    public WebController(PatientService patientService,
                         StaffService staffService,
                         AlertService alertService,
                         VitalRecordsService vitalRecordService,
                         ForecastService forecastService,
                         PatientAssessmentService patientAssessmentService) {
        this.patientService = patientService;
        this.staffService = staffService;
        this.alertService = alertService;
        this.vitalRecordService = vitalRecordService;
        this.forecastService = forecastService;
        this.patientAssessmentService = patientAssessmentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * Home Page
     */
    @GetMapping("/")
    public String home(Model model) {
        // Fetch patients arriving today
        List<Patient> patientsArrivingToday = patientService.getPatientsArrivingToday();
        for (Patient p : patientsArrivingToday) {
        // Convert from p.getAdmissionDate() to a String in 'yyyy-MM-dd' format
        // Assuming p.getAdmissionDate() returns a java.sql.Date or java.util.Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(p.getAdmissionDate());
        p.setFormattedAdmissionDate(formattedDate); // You'll need to add a transient field or DTO
    }
        model.addAttribute("patientsArrivingToday", patientsArrivingToday);
        model.addAttribute("numPatientsToday", patientsArrivingToday.size());

        // Fetch staff working today
        List<Staff> staffWorkingToday = staffService.getStaffWorkingToday();
        model.addAttribute("staffWorkingToday", staffWorkingToday);
        model.addAttribute("numStaffToday", staffWorkingToday.size());

        // Fetch high risk patients
        List<Patient> highRiskPatients = patientService.getHighRiskPatients();
        model.addAttribute("highRiskPatients", highRiskPatients);
        model.addAttribute("numHighRiskPatients", highRiskPatients.size());

        return "home";
    }


    /**
     * All Patients Page
     */
    @GetMapping("/patients")
    public String getAllPatients(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        List<VitalRecord> latestVitalRecords = vitalRecordService.getLatestVitalRecordsForAllPatients();

        // Option 1: Use AbstractMap.SimpleEntry for Java 8 Compatibility
        Map<Integer, VitalRecord> patientLatestVitalMap = latestVitalRecords.stream()
            .flatMap(vr -> vr.getPatientHasVitalRecords().stream()
                .map(phvr -> new AbstractMap.SimpleEntry<>(phvr.getPatient().getPatientId(), vr)))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (existing, replacement) -> existing // Keep the existing VitalRecord if duplicate keys are found
            ));

        // Option 2: Simplified Stream Operation using Direct Relationship
        /*
        Map<Integer, VitalRecord> patientLatestVitalMap = latestVitalRecords.stream()
            .collect(Collectors.toMap(
                vr -> vr.getPatient().getPatientId(),
                vr -> vr,
                (existing, replacement) -> existing // Keep the existing VitalRecord if duplicate keys are found
            ));
        */

        // Create PatientDTO list
        List<PatientDTO> patientDTOs = patients.stream().map(patient -> {
            VitalRecord latestRecord = patientLatestVitalMap.get(patient.getPatientId());
            boolean isHighRisk = false;
            if (latestRecord != null) {
                if (latestRecord.getHeartRate() != null && latestRecord.getHeartRate() > HEART_RATE_THRESHOLD) {
                    isHighRisk = true;
                }
                if (latestRecord.getTemperature() != null && latestRecord.getTemperature() > TEMPERATURE_THRESHOLD) {
                    isHighRisk = true;
                }
                // Add more conditions as needed
            }
            return new PatientDTO(patient, isHighRisk);
        }).collect(Collectors.toList());

        model.addAttribute("patients", patientDTOs);
        return "patients";
    }

    /**
     * Individual Patient Page
     */
    @GetMapping("/patients/{id}")
    public String getPatientById(@PathVariable Integer id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);

        List<PatientAssessment> assessments = patientAssessmentService.getAssessmentsForPatient(id);

        PatientAssessment assessment = null;
        if (!assessments.isEmpty()) {
            // For simplicity, take the first assessment in the list
            // If you want the most recent, sort by qDate and take the max:
            // assessments.sort(Comparator.comparing(PatientAssessment::getQDate).reversed());
            // assessment = assessments.get(0);
            
            assessment = assessments.get(0);
        }

        model.addAttribute("assessment", assessment);

        return "patient_detail";
    }

    /**
     * All Staff Page
     */
    @GetMapping("/staff")
    public String getAllStaff(Model model) {
        List<Staff> staffList = staffService.getAllStaff();
        model.addAttribute("staffList", staffList);
        return "staff";
    }

    /**
     * Individual Staff Page
     */
    @GetMapping("/staff/{id}")
    public String getStaffById(@PathVariable Integer id, Model model) {
        Staff staff = staffService.getStaffById(id);
        List<Alert> alerts = alertService.getAlertsByStaffId(id); // Ensure this method is implemented in AlertService
        model.addAttribute("staff", staff);
        model.addAttribute("alerts", alerts);
        return "staff_detail";
    }

    @GetMapping("/forecast")
    public String getForecast(Model model) {
        try {
            // Run the Python script to generate/refresh forecast.json
            forecastService.runForecastScript();

            // Now read the newly updated forecast.json
            ObjectMapper mapper = new ObjectMapper();
            try (FileInputStream fis = new FileInputStream(forecastService.getForecastJsonPath())) {
                ForecastEntry[] forecastData = mapper.readValue(fis, ForecastEntry[].class);
                model.addAttribute("forecast", forecastData);
            }
        } catch (IOException | InterruptedException e) {
            // Handle exceptions and possibly log them
            e.printStackTrace();
            model.addAttribute("forecast", null);
        }

        return "forecast";
    }

    static class ForecastEntry {
        public String day;
        public int expected_patients;
    }

    // ========== PATIENT CRUD ==========

    // Show form for creating a new Patient
    @GetMapping("/patients/new")
    public String showCreatePatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient_form"; // A thymeleaf template for patient form
    }

    // Handle form submission for creating a new Patient
    @PostMapping("/patients")
    public String createPatient(@ModelAttribute Patient patient) {
        patient.setAdmissionDate(new Date()); // For example, current date
        patient.setStatus("Admitted"); // Some default logic
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    // Show form for updating an existing Patient
    @GetMapping("/patients/edit/{id}")
    public String showEditPatientForm(@PathVariable Integer id, Model model) {
        Patient existing = patientService.getPatientById(id);
        if (existing == null) {
            return "redirect:/patients";
        }
        model.addAttribute("patient", existing);
        return "patient_form";
    }

    // Handle form submission for updating a Patient
    @PostMapping("/patients/update/{id}")
    public String updatePatient(@PathVariable Integer id, @ModelAttribute Patient updatedPatient) {
        // Since the form does not include riskFactor or riskLevel, they won't be changed
        Patient existing = patientService.getPatientById(id);
        if (existing == null) {
            return "redirect:/patients";
        }
        // Update allowed fields from updatedPatient to existing.
        existing.setFirstName(updatedPatient.getFirstName());
        existing.setLastName(updatedPatient.getLastName());
        existing.setSsn(updatedPatient.getSsn());
        existing.setDateOfBirth(updatedPatient.getDateOfBirth());
        existing.setGender(updatedPatient.getGender());
        existing.setBloodType(updatedPatient.getBloodType());

        patientService.savePatient(existing);
        return "redirect:/patients";
    }

    // Delete a Patient
    @GetMapping("/patients/delete/{id}")
    public String deletePatient(@PathVariable Integer id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }

    // ========== STAFF CRUD ==========

    @GetMapping("/staff/new")
    public String showCreateStaffForm(Model model) {
        model.addAttribute("staff", new Staff());
        return "staff_form";
    }

    @PostMapping("/staff")
    public String createStaff(@ModelAttribute Staff staff) {
        staffService.saveStaff(staff);
        return "redirect:/staff";
    }

    @GetMapping("/staff/edit/{id}")
    public String showEditStaffForm(@PathVariable Integer id, Model model) {
        Staff existing = staffService.getStaffById(id);
        if (existing == null) {
            return "redirect:/staff";
        }
        model.addAttribute("staff", existing);
        return "staff_form";
    }

    @PostMapping("/staff/update/{id}")
    public String updateStaff(@PathVariable Integer id, @ModelAttribute Staff staff) {
        staff.setStaffId(id);
        staffService.saveStaff(staff);
        return "redirect:/staff";
    }

    @GetMapping("/staff/delete/{id}")
    public String deleteStaff(@PathVariable Integer id) {
        staffService.deleteStaff(id);
        return "redirect:/staff";
    }
}
