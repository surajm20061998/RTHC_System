package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Alert")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alert_id")
    private Integer alertId;

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

    // Getters and Setters
    public Integer getAlertId() {
        return alertId;
    }

    public void setAlertId(Integer alertId) {
        this.alertId = alertId;
    }

    // ... [Include other getters and setters]
}
