package com.realTimeHealthcare.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class StaffTakesActionId implements Serializable {

    private Integer staff;
    private Integer alert;
    private Date actionTimestamp;

    public StaffTakesActionId() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StaffTakesActionId)) return false;
        StaffTakesActionId that = (StaffTakesActionId) o;
        return Objects.equals(staff, that.staff) &&
                Objects.equals(alert, that.alert) &&
                Objects.equals(actionTimestamp, that.actionTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staff, alert, actionTimestamp);
    }
}
