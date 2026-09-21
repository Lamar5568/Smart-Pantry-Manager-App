package com.smartpantry.api.dto;

public class UpdateSettingsRequest {

    private Boolean expiringSoonAlerts;
    private Integer expiryWarningDays;
    private String preferredUnitSystem;

    public UpdateSettingsRequest() {
    }

    public Boolean getExpiringSoonAlerts() {
        return expiringSoonAlerts;
    }

    public void setExpiringSoonAlerts(Boolean expiringSoonAlerts) {
        this.expiringSoonAlerts = expiringSoonAlerts;
    }

    public Integer getExpiryWarningDays() {
        return expiryWarningDays;
    }

    public void setExpiryWarningDays(Integer expiryWarningDays) {
        this.expiryWarningDays = expiryWarningDays;
    }

    public String getPreferredUnitSystem() {
        return preferredUnitSystem;
    }

    public void setPreferredUnitSystem(String preferredUnitSystem) {
        this.preferredUnitSystem = preferredUnitSystem;
    }
}