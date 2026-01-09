package se.johan.rentr.access.api.rest.v1.dto;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

/**
 * DTO representing a shopping cart.
 */
@Data
public class CartDto {
    /**
     * ID of the cart.
     */
    @JsonProperty(access = Access.READ_ONLY)
    private String id;

    /**
     * Total price of the cart after any discounts.
     */
    @JsonProperty(access = Access.READ_ONLY)
    private int totalAmount;

    /**
     * Items in the cart.
     */
    private Collection<CartItemDto> cartItems;
}
