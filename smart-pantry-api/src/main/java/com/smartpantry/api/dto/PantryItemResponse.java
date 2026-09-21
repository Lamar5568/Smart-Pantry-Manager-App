package com.smartpantry.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PantryItemResponse {

    private Long id;
    private String ingredientName;
    private BigDecimal quantity;
    private String unit;
    private LocalDate expiryDate;

    public PantryItemResponse() {
    }

    public PantryItemResponse(
            Long id,
            String ingredientName,
            BigDecimal quantity,
            String unit,
            LocalDate expiryDate) {

        this.id = id;
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.unit = unit;
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}