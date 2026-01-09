package se.johan.rentr.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collection;

import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

import lombok.Builder;
import lombok.Data;

/**
 * Domain model representing a Cart.
 */
@Builder(toBuilder = true)
@Data
public class Cart {
    /**
     * ID of the Cart.
     */
    private String id;

    /**
     * Last updated timestamp of the Cart.
     */
    private Instant lastUpdatedAt;

    /**
     * Total amount of the Cart, including discounts and taxes.
     */
    private MonetaryAmount totalAmount;

    /**
     * Collection of Cart Items associated with the Cart.
     */
    private Collection<CartItem> cartItems;

    /**
     * Calculates the total amount of the cart by summing up the prices of all cart items, applying any discounts.
     */
    public void calculateTotalAmount() {
        MonetaryAmount total = Money.of(0, "SEK");

        for (CartItem item : cartItems) {
            MonetaryAmount itemTotal = item.getEquipmentItem().getPricePerDay()
                    .multiply(item.getQuantity());

            if (item.getDiscountPercentage() != null) {
                itemTotal = itemTotal.multiply(BigDecimal.ONE.subtract(item.getDiscountPercentage().divide(BigDecimal.valueOf(100.0))));
            }

            total = total.add(itemTotal);
        }

        this.totalAmount = total;
    }
}
