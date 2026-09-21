package com.smartpantry.api.service;

import com.smartpantry.api.entity.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> findAll();

    Recipe findById(Long id);
}