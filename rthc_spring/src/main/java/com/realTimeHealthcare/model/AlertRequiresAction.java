package com.realTimeHealthcare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Alert_Requires_Action", schema = "dbo")
//@Table(name = "Alert_Requires_Action")
@IdClass(AlertRequiresActionId.class)
public class AlertRequiresAction {

    @Id
    @ManyToOne
    @JoinColumn(name = "alert_id")
    private Alert alert;

    @Id
    @Column(name = "required_action_type")
    private String requiredActionType;

    @Column(name = "required_response_time")
    private Integer requiredResponseTime;

    @Column(name = "priority_level")
    private String priorityLevel;

    @Column(name = "escalation_threshold")
    private Integer escalationThreshold;

    // Constructors
    public AlertRequiresAction() {}

    // Getters and Setters

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    public String getRequiredActionType() {
        return requiredActionType;
    }

    public void setRequiredActionType(String requiredActionType) {
        this.requiredActionType = requiredActionType;
    }

    public Integer getRequiredResponseTime() {
        return requiredResponseTime;
    }

    public void setRequiredResponseTime(Integer requiredResponseTime) {
        this.requiredResponseTime = requiredResponseTime;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public Integer getEscalationThreshold() {
        return escalationThreshold;
    }

    public void setEscalationThreshold(Integer escalationThreshold) {
        this.escalationThreshold = escalationThreshold;
    }
}
