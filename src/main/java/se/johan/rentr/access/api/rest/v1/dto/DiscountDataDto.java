package se.johan.rentr.access.api.rest.v1.dto;

import lombok.Data;

/**
 * DTO representing discount data.
 */
@Data
public class DiscountDataDto {
    /**
     * Location of the user, used to determine weather conditions for discount eligibility.
     */
    private LocationDto location;
}
