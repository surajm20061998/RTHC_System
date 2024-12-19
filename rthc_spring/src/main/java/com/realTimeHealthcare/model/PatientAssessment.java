package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PatientAssessment", schema = "dbo")
public class PatientAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_id")
    private Integer assessmentId;

    // @Column(name = "patient_id", nullable = false)
    // private Integer patientId; 

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "clinical_visit")
    private Integer clinicalVisit;

    @Column(name = "fried", length = 50)
    private String fried;

    @Column(name = "gender", length = 20)
    private String gender;

    @Column(name = "q_date")
    private LocalDateTime qDate;

    @Column(name = "age")
    private Integer age;

    @Column(name = "comorbidities_most_important", length = 255)
    private String comorbiditiesMostImportant;

    @Column(name = "hospitalization_one_year")
    private Integer hospitalizationOneYear;

    @Column(name = "hospitalization_three_years")
    private Integer hospitalizationThreeYears;

    @Column(name = "ortho_hypotension", length = 50)
    private String orthoHypotension;

    @Column(name = "vision", length = 50)
    private String vision;

    @Column(name = "audition", length = 50)
    private String audition;

    @Column(name = "weight_loss", length = 10)
    private String weightLoss;

    @Column(name = "exhaustion_score", precision = 10, scale = 2)
    private BigDecimal exhaustionScore;

    @Column(name = "raise_chair_time", precision = 10, scale = 2)
    private BigDecimal raiseChairTime;

    @Column(name = "balance_single", length = 50)
    private String balanceSingle;

    @Column(name = "gait_get_up", precision = 10, scale = 2)
    private BigDecimal gaitGetUp;

    @Column(name = "gait_speed_4m", precision = 10, scale = 2)
    private BigDecimal gaitSpeed4m;

    @Column(name = "gait_optional_binary", length = 10)
    private String gaitOptionalBinary;

    @Column(name = "gait_speed_slower", length = 10)
    private String gaitSpeedSlower;

    @Column(name = "grip_strength_abnormal", length = 10)
    private String gripStrengthAbnormal;

    @Column(name = "low_physical_activity", length = 10)
    private String lowPhysicalActivity;

    @Column(name = "falls_one_year")
    private Integer fallsOneYear;

    @Column(name = "fractures_three_years")
    private Integer fracturesThreeYears;

    @Column(name = "bmi_score", precision = 10, scale = 4)
    private BigDecimal bmiScore;

    @Column(name = "bmi_body_fat", precision = 10, scale = 2)
    private BigDecimal bmiBodyFat;

    @Column(name = "waist")
    private Integer waist;

    @Column(name = "lean_body_mass", precision = 10, scale = 4)
    private BigDecimal leanBodyMass;

    @Column(name = "screening_score")
    private Integer screeningScore;

    @Column(name = "mna_total", precision = 10, scale = 2)
    private BigDecimal mnaTotal;

    @Column(name = "cognitive_total_score")
    private Integer cognitiveTotalScore;

    @Column(name = "memory_complain", length = 50)
    private String memoryComplain;

    @Column(name = "sleep", length = 50)
    private String sleep;

    @Column(name = "mmse_total_score")
    private Integer mmseTotalScore;

    @Column(name = "depression_total_score")
    private Integer depressionTotalScore;

    @Column(name = "anxiety_perception", precision = 10, scale = 2)
    private BigDecimal anxietyPerception;

    @Column(name = "living_alone", length = 10)
    private String livingAlone;

    @Column(name = "leisure_out")
    private Integer leisureOut;

    @Column(name = "leisure_club", length = 10)
    private String leisureClub;

    @Column(name = "social_visits")
    private Integer socialVisits;

    @Column(name = "social_calls")
    private Integer socialCalls;

    @Column(name = "social_phone")
    private Integer socialPhone;

    @Column(name = "social_skype")
    private Integer socialSkype;

    @Column(name = "social_text")
    private Integer socialText;

    @Column(name = "house_suitable_participant", length = 10)
    private String houseSuitableParticipant;

    @Column(name = "house_suitable_professional", length = 10)
    private String houseSuitableProfessional;

    @Column(name = "stairs_number")
    private Integer stairsNumber;

    @Column(name = "life_quality", precision = 10, scale = 2)
    private BigDecimal lifeQuality;

    @Column(name = "health_rate", length = 50)
    private String healthRate;

    @Column(name = "health_rate_comparison", length = 50)
    private String healthRateComparison;

    @Column(name = "pain_perception", precision = 10, scale = 2)
    private BigDecimal painPerception;

    @Column(name = "activity_regular", length = 50)
    private String activityRegular;

    @Column(name = "smoking", length = 100)
    private String smoking;

    @Column(name = "alcohol_units", precision = 10, scale = 2)
    private BigDecimal alcoholUnits;

    @Column(name = "katz_index")
    private Integer katzIndex;

    @Column(name = "iadl_grade")
    private Integer iadlGrade;

    @Column(name = "comorbidities_count")
    private Integer comorbiditiesCount;

    @Column(name = "comorbidities_significant_count")
    private Integer comorbiditiesSignificantCount;

    @Column(name = "medication_count")
    private Integer medicationCount;

    public Integer getAssessmentId() {
    return assessmentId;
}

public void setAssessmentId(Integer assessmentId) {
    this.assessmentId = assessmentId;
}

public Patient getPatient() {
    return patient;
}

public void setPatient(Patient patient) {
    this.patient = patient;
}

public Integer getClinicalVisit() {
    return clinicalVisit;
}

public void setClinicalVisit(Integer clinicalVisit) {
    this.clinicalVisit = clinicalVisit;
}

public String getFried() {
    return fried;
}

public void setFried(String fried) {
    this.fried = fried;
}

public String getGender() {
    return gender;
}

public void setGender(String gender) {
    this.gender = gender;
}

public LocalDateTime getQDate() {
    return qDate;
}

public void setQDate(LocalDateTime qDate) {
    this.qDate = qDate;
}

public Integer getAge() {
    return age;
}

public void setAge(Integer age) {
    this.age = age;
}

public String getComorbiditiesMostImportant() {
    return comorbiditiesMostImportant;
}

public void setComorbiditiesMostImportant(String comorbiditiesMostImportant) {
    this.comorbiditiesMostImportant = comorbiditiesMostImportant;
}

public Integer getHospitalizationOneYear() {
    return hospitalizationOneYear;
}

public void setHospitalizationOneYear(Integer hospitalizationOneYear) {
    this.hospitalizationOneYear = hospitalizationOneYear;
}

public Integer getHospitalizationThreeYears() {
    return hospitalizationThreeYears;
}

public void setHospitalizationThreeYears(Integer hospitalizationThreeYears) {
    this.hospitalizationThreeYears = hospitalizationThreeYears;
}

public String getOrthoHypotension() {
    return orthoHypotension;
}

public void setOrthoHypotension(String orthoHypotension) {
    this.orthoHypotension = orthoHypotension;
}

public String getVision() {
    return vision;
}

public void setVision(String vision) {
    this.vision = vision;
}

public String getAudition() {
    return audition;
}

public void setAudition(String audition) {
    this.audition = audition;
}

public String getWeightLoss() {
    return weightLoss;
}

public void setWeightLoss(String weightLoss) {
    this.weightLoss = weightLoss;
}

public BigDecimal getExhaustionScore() {
    return exhaustionScore;
}

public void setExhaustionScore(BigDecimal exhaustionScore) {
    this.exhaustionScore = exhaustionScore;
}

public BigDecimal getRaiseChairTime() {
    return raiseChairTime;
}

public void setRaiseChairTime(BigDecimal raiseChairTime) {
    this.raiseChairTime = raiseChairTime;
}

public String getBalanceSingle() {
    return balanceSingle;
}

public void setBalanceSingle(String balanceSingle) {
    this.balanceSingle = balanceSingle;
}

public BigDecimal getGaitGetUp() {
    return gaitGetUp;
}

public void setGaitGetUp(BigDecimal gaitGetUp) {
    this.gaitGetUp = gaitGetUp;
}

public BigDecimal getGaitSpeed4m() {
    return gaitSpeed4m;
}

public void setGaitSpeed4m(BigDecimal gaitSpeed4m) {
    this.gaitSpeed4m = gaitSpeed4m;
}

public String getGaitOptionalBinary() {
    return gaitOptionalBinary;
}

public void setGaitOptionalBinary(String gaitOptionalBinary) {
    this.gaitOptionalBinary = gaitOptionalBinary;
}

public String getGaitSpeedSlower() {
    return gaitSpeedSlower;
}

public void setGaitSpeedSlower(String gaitSpeedSlower) {
    this.gaitSpeedSlower = gaitSpeedSlower;
}

public String getGripStrengthAbnormal() {
    return gripStrengthAbnormal;
}

public void setGripStrengthAbnormal(String gripStrengthAbnormal) {
    this.gripStrengthAbnormal = gripStrengthAbnormal;
}

public String getLowPhysicalActivity() {
    return lowPhysicalActivity;
}

public void setLowPhysicalActivity(String lowPhysicalActivity) {
    this.lowPhysicalActivity = lowPhysicalActivity;
}

public Integer getFallsOneYear() {
    return fallsOneYear;
}

public void setFallsOneYear(Integer fallsOneYear) {
    this.fallsOneYear = fallsOneYear;
}

public Integer getFracturesThreeYears() {
    return fracturesThreeYears;
}

public void setFracturesThreeYears(Integer fracturesThreeYears) {
    this.fracturesThreeYears = fracturesThreeYears;
}

public BigDecimal getBmiScore() {
    return bmiScore;
}

public void setBmiScore(BigDecimal bmiScore) {
    this.bmiScore = bmiScore;
}

public BigDecimal getBmiBodyFat() {
    return bmiBodyFat;
}

public void setBmiBodyFat(BigDecimal bmiBodyFat) {
    this.bmiBodyFat = bmiBodyFat;
}

public Integer getWaist() {
    return waist;
}

public void setWaist(Integer waist) {
    this.waist = waist;
}

public BigDecimal getLeanBodyMass() {
    return leanBodyMass;
}

public void setLeanBodyMass(BigDecimal leanBodyMass) {
    this.leanBodyMass = leanBodyMass;
}

public Integer getScreeningScore() {
    return screeningScore;
}

public void setScreeningScore(Integer screeningScore) {
    this.screeningScore = screeningScore;
}

public BigDecimal getMnaTotal() {
    return mnaTotal;
}

public void setMnaTotal(BigDecimal mnaTotal) {
    this.mnaTotal = mnaTotal;
}

public Integer getCognitiveTotalScore() {
    return cognitiveTotalScore;
}

public void setCognitiveTotalScore(Integer cognitiveTotalScore) {
    this.cognitiveTotalScore = cognitiveTotalScore;
}

public String getMemoryComplain() {
    return memoryComplain;
}

public void setMemoryComplain(String memoryComplain) {
    this.memoryComplain = memoryComplain;
}

public String getSleep() {
    return sleep;
}

public void setSleep(String sleep) {
    this.sleep = sleep;
}

public Integer getMmseTotalScore() {
    return mmseTotalScore;
}

public void setMmseTotalScore(Integer mmseTotalScore) {
    this.mmseTotalScore = mmseTotalScore;
}

public Integer getDepressionTotalScore() {
    return depressionTotalScore;
}

public void setDepressionTotalScore(Integer depressionTotalScore) {
    this.depressionTotalScore = depressionTotalScore;
}

public BigDecimal getAnxietyPerception() {
    return anxietyPerception;
}

public void setAnxietyPerception(BigDecimal anxietyPerception) {
    this.anxietyPerception = anxietyPerception;
}

public String getLivingAlone() {
    return livingAlone;
}

public void setLivingAlone(String livingAlone) {
    this.livingAlone = livingAlone;
}

public Integer getLeisureOut() {
    return leisureOut;
}

public void setLeisureOut(Integer leisureOut) {
    this.leisureOut = leisureOut;
}

public String getLeisureClub() {
    return leisureClub;
}

public void setLeisureClub(String leisureClub) {
    this.leisureClub = leisureClub;
}

public Integer getSocialVisits() {
    return socialVisits;
}

public void setSocialVisits(Integer socialVisits) {
    this.socialVisits = socialVisits;
}

public Integer getSocialCalls() {
    return socialCalls;
}

public void setSocialCalls(Integer socialCalls) {
    this.socialCalls = socialCalls;
}

public Integer getSocialPhone() {
    return socialPhone;
}

public void setSocialPhone(Integer socialPhone) {
    this.socialPhone = socialPhone;
}

public Integer getSocialSkype() {
    return socialSkype;
}

public void setSocialSkype(Integer socialSkype) {
    this.socialSkype = socialSkype;
}

public Integer getSocialText() {
    return socialText;
}

public void setSocialText(Integer socialText) {
    this.socialText = socialText;
}

public String getHouseSuitableParticipant() {
    return houseSuitableParticipant;
}

public void setHouseSuitableParticipant(String houseSuitableParticipant) {
    this.houseSuitableParticipant = houseSuitableParticipant;
}

public String getHouseSuitableProfessional() {
    return houseSuitableProfessional;
}

public void setHouseSuitableProfessional(String houseSuitableProfessional) {
    this.houseSuitableProfessional = houseSuitableProfessional;
}

public Integer getStairsNumber() {
    return stairsNumber;
}

public void setStairsNumber(Integer stairsNumber) {
    this.stairsNumber = stairsNumber;
}

public BigDecimal getLifeQuality() {
    return lifeQuality;
}

public void setLifeQuality(BigDecimal lifeQuality) {
    this.lifeQuality = lifeQuality;
}

public String getHealthRate() {
    return healthRate;
}

public void setHealthRate(String healthRate) {
    this.healthRate = healthRate;
}

public String getHealthRateComparison() {
    return healthRateComparison;
}

public void setHealthRateComparison(String healthRateComparison) {
    this.healthRateComparison = healthRateComparison;
}

public BigDecimal getPainPerception() {
    return painPerception;
}

public void setPainPerception(BigDecimal painPerception) {
    this.painPerception = painPerception;
}

public String getActivityRegular() {
    return activityRegular;
}

public void setActivityRegular(String activityRegular) {
    this.activityRegular = activityRegular;
}

public String getSmoking() {
    return smoking;
}

public void setSmoking(String smoking) {
    this.smoking = smoking;
}

public BigDecimal getAlcoholUnits() {
    return alcoholUnits;
}

public void setAlcoholUnits(BigDecimal alcoholUnits) {
    this.alcoholUnits = alcoholUnits;
}

public Integer getKatzIndex() {
    return katzIndex;
}

public void setKatzIndex(Integer katzIndex) {
    this.katzIndex = katzIndex;
}

public Integer getIadlGrade() {
    return iadlGrade;
}

public void setIadlGrade(Integer iadlGrade) {
    this.iadlGrade = iadlGrade;
}

public Integer getComorbiditiesCount() {
    return comorbiditiesCount;
}

public void setComorbiditiesCount(Integer comorbiditiesCount) {
    this.comorbiditiesCount = comorbiditiesCount;
}

public Integer getComorbiditiesSignificantCount() {
    return comorbiditiesSignificantCount;
}

public void setComorbiditiesSignificantCount(Integer comorbiditiesSignificantCount) {
    this.comorbiditiesSignificantCount = comorbiditiesSignificantCount;
}

public Integer getMedicationCount() {
    return medicationCount;
}

public void setMedicationCount(Integer medicationCount) {
    this.medicationCount = medicationCount;
}

}

