package se.johan.rentr.domain.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

/**
 * Domain model representing a Cart Item.
 */
@Builder
@Data
public class CartItem {
    /**
     * Equipment Item associated with the Cart Item.
     */
    private EquipmentItem equipmentItem;

    /**
     * Age of the renter in years.
     */
    private int ageInYears;

    /**
     * Discount percentage applied to the Cart Item, if any.
     */
    private BigDecimal discountPercentage;
    
    /**
     * Quantity of the Equipment Item in the Cart Item.
     */
    private int quantity;
}
