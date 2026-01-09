package se.johan.rentr.access.api.rest.v1.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import se.johan.rentr.access.api.rest.v1.dto.CartDto;
import se.johan.rentr.domain.model.Cart;

/**
 * Mapper interface for converting between Cart domain model and Cart DTO.
 */
@Mapper(uses = {CartItemDtoMapper.class})
public interface CartDtoMapper {
    /**
     * Convert CartDto to Cart domain model
     * 
     * @param cartDto The Cart DTO
     * @return The Cart domain model
     */
    @Mapping(target = "lastUpdatedAt", ignore = true)
    @Mapping(target = "totalAmount", ignore = true)
    Cart toDomain(CartDto cartDto);

    /**
     * Convert Cart domain model to CartDto
     * 
     * @param cart The Cart domain model
     * @return The Cart DTO
     */
    CartDto toDto(Cart cart);

}
