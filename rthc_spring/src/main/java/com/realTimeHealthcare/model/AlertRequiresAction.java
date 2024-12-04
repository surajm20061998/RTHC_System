package com.realTimeHealthcare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Alert_Requires_Action")
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

    // Getters and Setters
    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    // ... [Include other getters and setters]
}
