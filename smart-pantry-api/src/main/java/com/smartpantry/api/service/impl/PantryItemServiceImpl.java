package com.smartpantry.api.service.impl;

import com.smartpantry.api.entity.PantryItem;
import com.smartpantry.api.repository.PantryItemRepository;
import com.smartpantry.api.service.PantryItemService;
import com.smartpantry.api.util.IngredientNameNormalizer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PantryItemServiceImpl implements PantryItemService {

    private final PantryItemRepository pantryItemRepository;

    public PantryItemServiceImpl(PantryItemRepository pantryItemRepository) {
        this.pantryItemRepository = pantryItemRepository;
    }

    @Override
    public List<PantryItem> findAll() {
        return pantryItemRepository.findAll();
    }

    @Override
    public PantryItem findById(Long id) {
        return pantryItemRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pantry item not found: " + id));
    }

    @Override
    public PantryItem create(PantryItem pantryItem) {

        pantryItem.setNormalizedName(
                IngredientNameNormalizer.normalize(
                        pantryItem.getName()
                )
        );

        return pantryItemRepository.save(pantryItem);
    }

    @Override
    public PantryItem update(Long id, PantryItem pantryItem) {

        PantryItem existingItem = findById(id);

        existingItem.setName(pantryItem.getName());

        existingItem.setNormalizedName(
                IngredientNameNormalizer.normalize(
                        pantryItem.getName()
                )
        );

        existingItem.setQuantity(pantryItem.getQuantity());
        existingItem.setUnit(pantryItem.getUnit());
        existingItem.setExpiryDate(pantryItem.getExpiryDate());

        return pantryItemRepository.save(existingItem);
    }

    @Override
    public void delete(Long id) {

        PantryItem pantryItem = findById(id);

        pantryItemRepository.delete(pantryItem);
    }
}