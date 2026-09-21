package com.smartpantry.api.dto;

public class SettingsResponse {

    private Long id;
    private Boolean expiringSoonAlerts;
    private Integer expiryWarningDays;
    private String preferredUnitSystem;

    public SettingsResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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