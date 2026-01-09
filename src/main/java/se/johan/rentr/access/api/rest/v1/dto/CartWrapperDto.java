package se.johan.rentr.access.api.rest.v1.dto;

import lombok.Data;

/**
 * Wrapper DTO for Cart and associated Discount Data.
 */
@Data
public class CartWrapperDto {
    /**
     * The cart data transfer object.
     */
    private CartDto cart;

    /**
     * Discount data applied to the cart.
     */
    private DiscountDataDto discountData;
    
}
