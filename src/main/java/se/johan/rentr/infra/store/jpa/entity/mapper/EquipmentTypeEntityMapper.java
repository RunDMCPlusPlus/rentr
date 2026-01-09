package se.johan.rentr.infra.store.jpa.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import se.johan.rentr.domain.model.EquipmentType;
import se.johan.rentr.infra.store.jpa.entity.EquipmentTypeEntity;

/**
 * Mapper interface for converting between EquipmentType domain model and EquipmentTypeEntity.
 */
@Mapper
public interface EquipmentTypeEntityMapper {
    /**
     * Maps EquipmentTypeEntity to EquipmentType.
     * 
     * @param equipmentTypeEntity The EquipmentTypeEntity.
     * @return The corresponding EquipmentType domain model.
     */
    EquipmentType toDomain(EquipmentTypeEntity equipmentTypeEntity);

    /**
     * Maps EquipmentType to EquipmentTypeEntity.
     * 
     * @param equipmentType The EquipmentType domain model.
     * @return The corresponding EquipmentTypeEntity.
     */
    @Mapping(target = "databaseId", ignore = true)
    EquipmentTypeEntity toEntity(EquipmentType equipmentType);
}
