package com.smartpantry.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "app_settings")
public class AppSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expiring_soon_alerts", nullable = false)
    private Boolean expiringSoonAlerts;

    @Column(name = "expiry_warning_days", nullable = false)
    private Integer expiryWarningDays;

    @Column(name = "preferred_unit_system", nullable = false)
    private String preferredUnitSystem;

    // Getters and Setters

    public Long getId() {
        return id;
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
