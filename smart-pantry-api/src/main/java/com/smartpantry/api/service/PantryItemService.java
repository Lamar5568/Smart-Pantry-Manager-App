package com.smartpantry.api.service;

import com.smartpantry.api.entity.PantryItem;

import java.util.List;

public interface PantryItemService {

    List<PantryItem> findAll();

    PantryItem findById(Long id);

    PantryItem create(PantryItem pantryItem);

    PantryItem update(Long id, PantryItem pantryItem);

    void delete(Long id);
}