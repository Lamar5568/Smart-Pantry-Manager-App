package com.smartpantry.api.service.impl;

import com.smartpantry.api.entity.Recipe;
import com.smartpantry.api.repository.RecipeRepository;
import com.smartpantry.api.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Recipe not found: " + id));
    }
}