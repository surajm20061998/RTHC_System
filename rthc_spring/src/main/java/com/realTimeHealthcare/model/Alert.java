package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Alert", schema = "dbo")
//@Table(name = "Alert")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alert_id")
    private Integer alertId;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Column(name = "alert_type")
    private String alertType;

    private String severity;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String status;

    // Relationships
    @OneToMany(mappedBy = "alert")
    private Set<VitalRecordsTriggersAlert> vitalRecordsTriggered;

    @OneToMany(mappedBy = "alert")
    private Set<AlertRequiresAction> requiredActions;

    @OneToMany(mappedBy = "alert")
    private Set<StaffTakesAction> actionsTaken;

    // Constructors
    public Alert() {}

    // Getters and Setters

    public Integer getAlertId() {
        return alertId;
    }

    public void setAlertId(Integer alertId) {
        this.alertId = alertId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<VitalRecordsTriggersAlert> getVitalRecordsTriggered() {
        return vitalRecordsTriggered;
    }

    public void setVitalRecordsTriggered(Set<VitalRecordsTriggersAlert> vitalRecordsTriggered) {
        this.vitalRecordsTriggered = vitalRecordsTriggered;
    }

    public Set<AlertRequiresAction> getRequiredActions() {
        return requiredActions;
    }

    public void setRequiredActions(Set<AlertRequiresAction> requiredActions) {
        this.requiredActions = requiredActions;
    }

    public Set<StaffTakesAction> getActionsTaken() {
        return actionsTaken;
    }

    public void setActionsTaken(Set<StaffTakesAction> actionsTaken) {
        this.actionsTaken = actionsTaken;
    }
}
