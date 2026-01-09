package se.johan.rentr.infra.store.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se.johan.rentr.infra.store.jpa.entity.EquipmentItemEntity;

/**
 * JPA Repository interface for EquipmentItem entities.
 */
public interface EquipmentItemRepository extends JpaRepository<EquipmentItemEntity, Long> {
    /**
     * Finds a EquipmentItemEntity by its ID.
     * 
     * @param id The ID of the equipment item.
     * @return The EquipmentItemEntity with the given ID.
     */
    EquipmentItemEntity findById(String id);

    /**
     * Finds a EquipmentItemEntity by Equipment Type ID and Age Category ID.
     * 
     * @param equipmentTypeId The ID of the equipment type.
     * @param ageCategoryId The ID of the age category.
     * @return The EquipmentItemEntity matching the given equipment type and age category.
     */
    EquipmentItemEntity findByEquipmentTypeIdAndAgeCategoryId(String equipmentTypeId, String ageCategoryId);
}
