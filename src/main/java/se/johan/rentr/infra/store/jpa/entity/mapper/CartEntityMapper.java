package se.johan.rentr.infra.store.jpa.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import se.johan.rentr.domain.model.Cart;
import se.johan.rentr.infra.store.jpa.entity.CartEntity;

/**
 * Mapper interface for converting between Cart domain model and CartEntity.
 */
@Mapper(uses = {CartItemEntityMapper.class})
public interface CartEntityMapper {
    /**
     * Maps CartEntity to Cart.
     * 
     * @param cartEntity The CartEntity.
     * @return The corresponding Cart domain model.
     */
    @Mapping(target = "totalAmount", ignore = true)
    Cart toDomain(CartEntity cartEntity);

    /**
     * Maps Cart to CartEntity.
     * 
     * @param cart The Cart domain model.
     * @return The corresponding CartEntity.
     */
    @Mapping(target = "databaseId", ignore = true)
    CartEntity toEntity(Cart cart);
}
