package com.realTimeHealthcare.model;

import java.io.Serializable;
import java.util.Objects;

public class AlertRequiresActionId implements Serializable {

    private Integer alert;
    private String requiredActionType;

    // Default constructor
    public AlertRequiresActionId() {
    }

    // Getters and Setters
    public Integer getAlert() {
        return alert;
    }

    public void setAlert(Integer alert) {
        this.alert = alert;
    }

    public String getRequiredActionType() {
        return requiredActionType;
    }

    public void setRequiredActionType(String requiredActionType) {
        this.requiredActionType = requiredActionType;
    }

    // hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(alert, requiredActionType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AlertRequiresActionId)) return false;
        AlertRequiresActionId that = (AlertRequiresActionId) obj;
        return Objects.equals(alert, that.alert) &&
                Objects.equals(requiredActionType, that.requiredActionType);
    }
}
