package com.realTimeHealthcare.model;

import java.io.Serializable;
import java.util.Objects;

public class AlertRequiresActionId implements Serializable {

    private Integer alert;
    private String requiredActionType;

    public AlertRequiresActionId() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlertRequiresActionId)) return false;
        AlertRequiresActionId that = (AlertRequiresActionId) o;
        return Objects.equals(alert, that.alert) &&
                Objects.equals(requiredActionType, that.requiredActionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alert, requiredActionType);
    }
}
