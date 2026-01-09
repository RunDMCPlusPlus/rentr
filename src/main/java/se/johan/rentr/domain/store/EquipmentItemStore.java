package se.johan.rentr.domain.store;

import se.johan.rentr.domain.model.EquipmentItem;

/**
 * Store interface for managing Equipment Items.
 */
public interface EquipmentItemStore {
    /**
     * Get Equipment Item by Equipment Type ID and Age Category ID
     * 
     * @param equipmentTypeId ID of the Equipment Type
     * @param ageCategoryId ID of the Age Category
     * @return The Equipment Item
     */
    EquipmentItem getEquipmentItemByTypeAndAgeCategory(String equipmentTypeId, String ageCategoryId);
}
