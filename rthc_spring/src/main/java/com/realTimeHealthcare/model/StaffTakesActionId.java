package com.realTimeHealthcare.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class StaffTakesActionId implements Serializable {

    private Integer staff;
    private Integer alert;
    private Date actionTimestamp;

    // Default constructor
    public StaffTakesActionId() {
    }

    // Getters and Setters
    public Integer getStaff() {
        return staff;
    }

    public void setStaff(Integer staff) {
        this.staff = staff;
    }

    public Integer getAlert() {
        return alert;
    }

    public void setAlert(Integer alert) {
        this.alert = alert;
    }

    public Date getActionTimestamp() {
        return actionTimestamp;
    }

    public void setActionTimestamp(Date actionTimestamp) {
        this.actionTimestamp = actionTimestamp;
    }

    // hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(staff, alert, actionTimestamp);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StaffTakesActionId)) return false;
        StaffTakesActionId that = (StaffTakesActionId) obj;
        return Objects.equals(staff, that.staff) &&
                Objects.equals(alert, that.alert) &&
                Objects.equals(actionTimestamp, that.actionTimestamp);
    }
}
