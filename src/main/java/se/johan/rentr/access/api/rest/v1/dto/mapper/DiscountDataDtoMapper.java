package se.johan.rentr.access.api.rest.v1.dto.mapper;

import org.mapstruct.Mapper;

import se.johan.rentr.access.api.rest.v1.dto.DiscountDataDto;
import se.johan.rentr.domain.model.DiscountData;

/**
 * Mapper interface for converting between DiscountData domain model and DiscountData DTO.
 */
@Mapper
public interface DiscountDataDtoMapper {
    public DiscountData toDomain(DiscountDataDto discountDataDto);
    
}
