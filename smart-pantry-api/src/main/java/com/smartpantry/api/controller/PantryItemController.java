package com.smartpantry.api.controller;

import com.smartpantry.api.entity.PantryItem;
import com.smartpantry.api.service.PantryItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pantry")
@CrossOrigin(origins = "*")
public class PantryItemController {

    private final PantryItemService pantryItemService;

    public PantryItemController(PantryItemService pantryItemService) {
        this.pantryItemService = pantryItemService;
    }

    @GetMapping
    public List<PantryItem> getAll() {
        return pantryItemService.findAll();
    }

    @GetMapping("/{id}")
    public PantryItem getById(@PathVariable Long id) {
        return pantryItemService.findById(id);
    }

    @PostMapping
    public PantryItem create(@RequestBody PantryItem pantryItem) {
        return pantryItemService.create(pantryItem);
    }

    @PutMapping("/{id}")
    public PantryItem update(
            @PathVariable Long id,
            @RequestBody PantryItem pantryItem) {

        return pantryItemService.update(id, pantryItem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pantryItemService.delete(id);
    }
}