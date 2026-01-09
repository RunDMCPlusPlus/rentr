package se.johan.rentr.infra.store.jpa.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import se.johan.rentr.domain.model.AgeCategory;
import se.johan.rentr.infra.store.jpa.entity.AgeCategoryEntity;

/**
 * Mapper interface for converting between AgeCategory domain model and AgeCategoryEntity.
 */
@Mapper
public interface AgeCategoryEntityMapper {
    /**
     * Maps AgeCategoryEntity to AgeCategory.
     * 
     * @param ageCategoryEntity The AgeCategoryEntity.
     * @return The corresponding AgeCategory domain model.
     */
    AgeCategory toDomain(AgeCategoryEntity ageCategoryEntity);

    /**
     * Maps AgeCategory to AgeCategoryEntity.
     * 
     * @param ageCategory The AgeCategory domain model.
     * @return The corresponding AgeCategoryEntity.
     */
    @Mapping(target = "databaseId", ignore = true)
    AgeCategoryEntity toEntity(AgeCategory ageCategory);
}
