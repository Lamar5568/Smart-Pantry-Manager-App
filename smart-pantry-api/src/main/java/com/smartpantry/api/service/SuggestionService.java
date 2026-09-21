package com.smartpantry.api.service;

import com.smartpantry.api.entity.Recipe;
import com.smartpantry.api.dto.SuggestedRecipeResponse;

import java.util.List;

public interface SuggestionService {

    List<SuggestedRecipeResponse> getSuggestedRecipes();
}