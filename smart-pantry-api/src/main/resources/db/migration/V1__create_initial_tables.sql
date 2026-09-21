CREATE TABLE pantry_items (
                              id BIGSERIAL PRIMARY KEY,
                              name VARCHAR(100) NOT NULL,
                              normalized_name VARCHAR(100) NOT NULL,
                              quantity NUMERIC(10, 2) NOT NULL,
                              unit VARCHAR(30) NOT NULL,
                              expiry_date DATE,
                              created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                              CONSTRAINT pantry_quantity_positive
                                  CHECK (quantity > 0)
);

CREATE TABLE recipes (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(150) NOT NULL UNIQUE,
                         description TEXT NOT NULL,
                         preparation_time_minutes INTEGER NOT NULL,
                         difficulty_level VARCHAR(20) NOT NULL,
                         instructions TEXT NOT NULL,

                         CONSTRAINT preparation_time_positive
                             CHECK (preparation_time_minutes > 0)
);

CREATE TABLE recipe_ingredients (
                                    id BIGSERIAL PRIMARY KEY,
                                    recipe_id BIGINT NOT NULL,
                                    ingredient_name VARCHAR(100) NOT NULL,
                                    normalized_name VARCHAR(100) NOT NULL,
                                    required_quantity NUMERIC(10, 2) NOT NULL,
                                    unit VARCHAR(30) NOT NULL,

                                    CONSTRAINT recipe_ingredient_quantity_positive
                                        CHECK (required_quantity > 0),

                                    CONSTRAINT recipe_ingredients_recipe_fk
                                        FOREIGN KEY (recipe_id)
                                            REFERENCES recipes(id)
                                            ON DELETE CASCADE
);

CREATE TABLE app_settings (
                              id BIGSERIAL PRIMARY KEY,
                              expiring_soon_alerts BOOLEAN NOT NULL DEFAULT TRUE,
                              expiry_warning_days INTEGER NOT NULL DEFAULT 3,
                              preferred_unit_system VARCHAR(20) NOT NULL DEFAULT 'METRIC'
);

CREATE INDEX idx_pantry_normalized_name
    ON pantry_items(normalized_name);

CREATE INDEX idx_recipe_ingredient_recipe
    ON recipe_ingredients(recipe_id);

CREATE INDEX idx_recipe_ingredient_normalized_name
    ON recipe_ingredients(normalized_name);