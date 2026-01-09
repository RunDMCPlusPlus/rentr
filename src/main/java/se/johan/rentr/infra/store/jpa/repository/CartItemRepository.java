package se.johan.rentr.infra.store.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se.johan.rentr.infra.store.jpa.entity.CartItemEntity;

/**
 * JPA Repository interface for CartItem entities.
 */
public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {
}
