package com.smartpantry.api.repository;

import com.smartpantry.api.entity.PantryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PantryItemRepository extends JpaRepository<PantryItem, Long> {

    Optional<PantryItem> findByNormalizedName(String normalizedName);

    boolean existsByNormalizedName(String normalizedName);
}