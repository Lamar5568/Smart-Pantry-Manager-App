package com.smartpantry.api.service;

import com.smartpantry.api.entity.AppSettings;

public interface AppSettingsService {

    AppSettings getSettings();

    AppSettings updateSettings(
            AppSettings appSettings);
}