package com.smartpantry.api.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class IngredientNameNormalizer {

    private static final Map<String, String> ALIASES = new HashMap<>();

    static {
        ALIASES.put("tomatoes", "tomato");
        ALIASES.put("potatoes", "potato");
        ALIASES.put("onions", "onion");
        ALIASES.put("eggs", "egg");
        ALIASES.put("carrots", "carrot");
        ALIASES.put("apples", "apple");
        ALIASES.put("bananas", "banana");
        ALIASES.put("chilies", "chili");
        ALIASES.put("chillies", "chili");
        ALIASES.put("bell peppers", "bell pepper");
        ALIASES.put("green peppers", "green pepper");
        ALIASES.put("red peppers", "red pepper");
        ALIASES.put("spring onions", "spring onion");
        ALIASES.put("scallions", "spring onion");
    }

    private IngredientNameNormalizer() {
    }

    public static String normalize(String value) {

        if (value == null || value.isBlank()) {
            return "";
        }

        String normalized = value
                .trim()
                .toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z0-9\\s]", " ")
                .replaceAll("\\s+", " ");

        String alias = ALIASES.get(normalized);

        if (alias != null) {
            return alias;
        }

        return applySimpleSingularForm(normalized);
    }

    private static String applySimpleSingularForm(String value) {

        if (value.endsWith("ies") && value.length() > 3) {
            return value.substring(0, value.length() - 3) + "y";
        }

        if (value.endsWith("ches")
                || value.endsWith("shes")
                || value.endsWith("xes")
                || value.endsWith("zes")) {

            return value.substring(0, value.length() - 2);
        }

        if (value.endsWith("s")
                && !value.endsWith("ss")
                && value.length() > 1) {

            return value.substring(0, value.length() - 1);
        }

        return value;
    }
}