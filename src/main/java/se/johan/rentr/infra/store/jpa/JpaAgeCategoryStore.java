package se.johan.rentr.infra.store.jpa;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import se.johan.rentr.domain.model.AgeCategory;
import se.johan.rentr.domain.store.AgeCategoryStore;
import se.johan.rentr.infra.store.jpa.entity.mapper.AgeCategoryEntityMapper;
import se.johan.rentr.infra.store.jpa.repository.AgeCategoryRepository;

/**
 * JPA implementation of AgeCategoryStore.
 */
@RequiredArgsConstructor
@Service
public class JpaAgeCategoryStore implements AgeCategoryStore {
    /**
     * The AgeCategory repository.
     */
    private final AgeCategoryRepository ageCategoryRepository;

    /**
     * The AgeCategory entity mapper.
     */
    private final AgeCategoryEntityMapper ageCategoryEntityMapper;

    @Override
    public List<AgeCategory> getAllAgeCategories() {
        return ageCategoryRepository.findAll().stream()
                .map(ageCategoryEntityMapper::toDomain)
                .toList();
    }
    
}
