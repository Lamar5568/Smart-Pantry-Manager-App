package com.smartpantry.api.service.impl;

import com.smartpantry.api.dto.SuggestedRecipeResponse;
import com.smartpantry.api.entity.PantryItem;
import com.smartpantry.api.entity.Recipe;
import com.smartpantry.api.entity.RecipeIngredient;
import com.smartpantry.api.repository.PantryItemRepository;
import com.smartpantry.api.repository.RecipeIngredientRepository;
import com.smartpantry.api.repository.RecipeRepository;
import com.smartpantry.api.service.SuggestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SuggestionServiceImpl
        implements SuggestionService {

    private final RecipeRepository recipeRepository;
    private final RecipeIngredientRepository ingredientRepository;
    private final PantryItemRepository pantryItemRepository;

    public SuggestionServiceImpl(
            RecipeRepository recipeRepository,
            RecipeIngredientRepository ingredientRepository,
            PantryItemRepository pantryItemRepository) {

        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.pantryItemRepository = pantryItemRepository;
    }

    @Override
    public List<SuggestedRecipeResponse> getSuggestedRecipes() {

        List<Recipe> recipes =
                recipeRepository.findAll();

        List<PantryItem> pantryItems =
                pantryItemRepository.findAll();

        List<RecipeIngredient> allIngredients =
                ingredientRepository.findAll();

        Map<String, PantryItem> pantryMap =
                pantryItems.stream()
                        .collect(Collectors.toMap(
                                PantryItem::getNormalizedName,
                                item -> item
                        ));

        Map<Long, List<RecipeIngredient>> ingredientsByRecipe =
                allIngredients.stream()
                        .collect(Collectors.groupingBy(
                                RecipeIngredient::getRecipeId
                        ));

        List<SuggestedRecipeResponse> matches =
                new ArrayList<>();

        for (Recipe recipe : recipes) {

            List<RecipeIngredient> ingredients =
                    ingredientsByRecipe.getOrDefault(
                            recipe.getId(),
                            new ArrayList<>()
                    );

            boolean canMakeRecipe = true;

            int matchedIngredients = 0;

            for (RecipeIngredient ingredient : ingredients) {

                PantryItem pantryItem =
                        pantryMap.get(
                                ingredient.getNormalizedName()
                        );

                if (pantryItem == null) {
                    canMakeRecipe = false;
                    break;
                }

                if (!pantryItem.getUnit()
                        .equals(ingredient.getUnit())) {

                    canMakeRecipe = false;
                    break;
                }

                if (pantryItem.getQuantity()
                        .compareTo(
                                ingredient.getRequiredQuantity()
                        ) < 0) {

                    canMakeRecipe = false;
                    break;
                }

                matchedIngredients++;
            }

            if (canMakeRecipe) {

                SuggestedRecipeResponse response =
                        new SuggestedRecipeResponse();

                response.setId(
                        recipe.getId()
                );

                response.setName(
                        recipe.getName()
                );

                response.setDescription(
                        recipe.getDescription()
                );

                response.setPreparationTimeMinutes(
                        recipe.getPreparationTimeMinutes()
                );

                response.setDifficultyLevel(
                        recipe.getDifficultyLevel()
                );

                response.setInstructions(
                        recipe.getInstructions()
                );

                int matchPercentage =
                        ingredients.isEmpty()
                                ? 0
                                : (matchedIngredients * 100)
                                / ingredients.size();

                response.setMatchPercentage(
                        matchPercentage
                );

                matches.add(response);
            }
        }

        return matches;
    }
}