package com.realTimeHealthcare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Staff_Takes_Action", schema = "dbo")
@IdClass(StaffTakesActionId.class)
public class StaffTakesAction {

    @Id
    @ManyToOne
    @JoinColumn(name = "staff_id", insertable = false, updatable = false)
    private Staff staff;

    @Id
    @ManyToOne
    @JoinColumn(name = "alert_id", insertable = false, updatable = false)
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

    // Constructors
    public StaffTakesAction() {}

    // Getters and Setters

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    public Date getActionTimestamp() {
        return actionTimestamp;
    }

    public void setActionTimestamp(Date actionTimestamp) {
        this.actionTimestamp = actionTimestamp;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public Integer getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Integer responseTime) {
        this.responseTime = responseTime;
    }

    public Boolean getFollowUpRequired() {
        return followUpRequired;
    }

    public void setFollowUpRequired(Boolean followUpRequired) {
        this.followUpRequired = followUpRequired;
    }

    @Override
    public String toString() {
        return actionTaken != null ? actionTaken : "";
    }
}
