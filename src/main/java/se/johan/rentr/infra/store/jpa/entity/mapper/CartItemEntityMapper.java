package se.johan.rentr.infra.store.jpa.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import se.johan.rentr.domain.model.CartItem;
import se.johan.rentr.infra.store.jpa.entity.CartItemEntity;

/**
 * Mapper interface for converting between CartItem domain model and CartItemEntity.
 */
@Mapper(uses = {EquipmentItemEntityMapper.class})
public interface CartItemEntityMapper {
    /**
     * Maps CartItemEntity to CartItem.
     * 
     * @param cartItemEntity The CartItemEntity.
     * @return The corresponding CartItem domain model.
     */
    @Mapping(target = "ageInYears", ignore = true)
    CartItem toDomain(CartItemEntity cartItemEntity);

    /**
     * Maps CartItem to CartItemEntity.
     * 
     * @param cartItem The CartItem domain model.
     * @return The corresponding CartItemEntity.
     */
    @Mapping(target = "databaseId", ignore = true)
    @Mapping(target = "cart", ignore = true)
    CartItemEntity toEntity(CartItem cartItem);
}
