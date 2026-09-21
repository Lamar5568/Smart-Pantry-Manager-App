package com.smartpantry.api.controller;

import com.smartpantry.api.entity.AppSettings;
import com.smartpantry.api.service.AppSettingsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings")
@CrossOrigin(origins = "*")
public class AppSettingsController {

    private final AppSettingsService appSettingsService;

    public AppSettingsController(
            AppSettingsService appSettingsService) {

        this.appSettingsService = appSettingsService;
    }

    @GetMapping
    public AppSettings getSettings() {
        return appSettingsService.getSettings();
    }

    @PutMapping
    public AppSettings updateSettings(
            @RequestBody AppSettings settings) {

        return appSettingsService.updateSettings(settings);
    }
}
