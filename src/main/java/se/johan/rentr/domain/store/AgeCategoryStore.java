package se.johan.rentr.domain.store;

import java.util.List;

import se.johan.rentr.domain.model.AgeCategory;

/**
 * Store interface for managing Age Categories.
 */
public interface AgeCategoryStore {

    /**
     * Get all Age Categories
     * 
     * @return List of Age Categories
     */
    List<AgeCategory> getAllAgeCategories();
}
