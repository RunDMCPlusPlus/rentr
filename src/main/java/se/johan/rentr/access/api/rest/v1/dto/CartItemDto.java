package se.johan.rentr.access.api.rest.v1.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * DTO representing an item in the shopping cart.
 */
@Data
public class CartItemDto {
    /**
     * ID of the equipment item.
     */
    private String equipmentTypeId;

    /**
     * Age category ID for the renter.
     */
    private String ageCategoryId;

    /**
     * Age of the renter in years. Either ageCategoryId or ageInYears should be provided.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int ageInYears;

    /**
     * Discount percentage applied to the equipment item.
     */
    private BigDecimal discountPercentage;

    /**
     * Quantity of the equipment item in the cart.
     */
    private int quantity;

    /**
     * Price per day for the equipment item.
     */
    private int pricePerDay;
}
