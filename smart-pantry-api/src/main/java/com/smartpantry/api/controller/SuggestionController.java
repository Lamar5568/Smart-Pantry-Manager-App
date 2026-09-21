package com.smartpantry.api.controller;

import com.smartpantry.api.dto.SuggestedRecipeResponse;
import com.smartpantry.api.service.SuggestionService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
@CrossOrigin(origins = "*")
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @GetMapping
    public List<SuggestedRecipeResponse> getSuggestions() {
        return suggestionService.getSuggestedRecipes();
    }
}