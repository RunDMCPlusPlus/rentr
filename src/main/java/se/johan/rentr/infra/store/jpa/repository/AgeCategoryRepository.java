package se.johan.rentr.infra.store.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se.johan.rentr.infra.store.jpa.entity.AgeCategoryEntity;

/**
 * JPA Repository interface for AgeCategory entities.
 */
public interface AgeCategoryRepository extends JpaRepository<AgeCategoryEntity, Long> {
}