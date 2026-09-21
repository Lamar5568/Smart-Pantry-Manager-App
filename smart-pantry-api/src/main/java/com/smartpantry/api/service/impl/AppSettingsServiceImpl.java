package com.smartpantry.api.service.impl;

import com.smartpantry.api.entity.AppSettings;
import com.smartpantry.api.repository.AppSettingsRepository;
import com.smartpantry.api.service.AppSettingsService;
import org.springframework.stereotype.Service;

@Service
public class AppSettingsServiceImpl
        implements AppSettingsService {

    private final AppSettingsRepository repository;

    public AppSettingsServiceImpl(
            AppSettingsRepository repository) {

        this.repository = repository;
    }

    @Override
    public AppSettings getSettings() {

        return repository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException(
                                "Settings not found"));
    }

    @Override
    public AppSettings updateSettings(
            AppSettings appSettings) {

        AppSettings existing =
                getSettings();

        existing.setExpiringSoonAlerts(
                appSettings.getExpiringSoonAlerts());

        existing.setExpiryWarningDays(
                appSettings.getExpiryWarningDays());

        existing.setPreferredUnitSystem(
                appSettings.getPreferredUnitSystem());

        return repository.save(existing);
    }
}