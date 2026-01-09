package se.johan.rentr.access.api.rest.v1.dto.mapper;

import javax.money.MonetaryAmount;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import se.johan.rentr.access.api.rest.v1.dto.CartItemDto;
import se.johan.rentr.domain.model.CartItem;

/**
 * Mapper interface for converting between CartItem domain model and CartItem DTO.
 */
@Mapper
public interface CartItemDtoMapper {
    /**
     * Convert CartItemDto to CartItem domain model
     * 
     * @param cartItemDto The CartItem DTO
     * @return The CartItem domain model
     */
    @Mapping(target = "equipmentItem.equipmentType.id", source = "equipmentTypeId")
    @Mapping(target = "equipmentItem.ageCategory.id", source = "ageCategoryId")
    CartItem toDomain(CartItemDto cartItemDto);

    /**
     * Convert CartItem domain model to CartItemDto
     * 
     * @param cartItem The CartItem domain model
     * @return The CartItem DTO
     */
    @Mapping(target = "equipmentTypeId", source = "equipmentItem.equipmentType.id")
    @Mapping(target = "ageCategoryId", source = "equipmentItem.ageCategory.id")
    @Mapping(target = "pricePerDay", source = "equipmentItem.pricePerDay")
    CartItemDto toDto(CartItem cartItem);
    
    /**
     * Map MonetaryAmount to integer value.
     * 
     * @param monetaryAmount The MonetaryAmount
     * @return The integer value of the monetary amount
     */
    public default int map(MonetaryAmount monetaryAmount) {
        if (monetaryAmount == null) {
            return 0;
        }
        return monetaryAmount.getNumber().intValueExact();
    }
}
