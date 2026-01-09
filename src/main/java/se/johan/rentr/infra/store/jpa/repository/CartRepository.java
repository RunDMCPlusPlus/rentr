package se.johan.rentr.infra.store.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se.johan.rentr.infra.store.jpa.entity.CartEntity;

/**
 * JPA Repository for CartEntity.
 */
public interface CartRepository extends JpaRepository<CartEntity, Long> {
    /**
     * Finds a CartEntity by its ID.
     * 
     * @param id The ID of the cart.
     * @return The CartEntity with the given ID.
     */
    CartEntity findById(String id);
    
}
