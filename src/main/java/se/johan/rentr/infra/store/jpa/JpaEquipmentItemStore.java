package se.johan.rentr.infra.store.jpa;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import se.johan.rentr.domain.model.EquipmentItem;
import se.johan.rentr.domain.store.EquipmentItemStore;
import se.johan.rentr.infra.store.jpa.entity.mapper.EquipmentItemEntityMapper;
import se.johan.rentr.infra.store.jpa.repository.EquipmentItemRepository;

/**
 * JPA implementation of EquipmentItemStore.
 */
@RequiredArgsConstructor
@Service
public class JpaEquipmentItemStore implements EquipmentItemStore {
    /**
     * Repository for EquipmentItemEntity.
     */
    private final EquipmentItemRepository equipmentItemRepository;

    /**
     * Mapper for EquipmentItemEntity and EquipmentItem domain model.
     */
    private final EquipmentItemEntityMapper equipmentItemEntityMapper;

    @Override
    public EquipmentItem getEquipmentItemByTypeAndAgeCategory(String equipmentTypeId, String ageCategoryId) {
        return equipmentItemEntityMapper.toDomain(
                equipmentItemRepository.findByEquipmentTypeIdAndAgeCategoryId(equipmentTypeId, ageCategoryId));
    }
    
}
