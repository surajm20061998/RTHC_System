package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Staff_Takes_Action")
@IdClass(StaffTakesActionId.class)
public class StaffTakesAction {

    @Id
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @Id
    @ManyToOne
    @JoinColumn(name = "alert_id")
    private Alert alert;

    @Id
    @Column(name = "action_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionTimestamp;

    @Column(name = "action_taken", columnDefinition = "TEXT")
    private String actionTaken;

    @Column(name = "response_time")
    private Integer responseTime;

    @Column(name = "follow_up_required")
    private Boolean followUpRequired;

    // Getters and Setters
    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    // ... [Include other getters and setters]
}
