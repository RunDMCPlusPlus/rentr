package se.johan.rentr.domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import se.johan.rentr.domain.model.AgeCategory;
import se.johan.rentr.domain.model.Cart;
import se.johan.rentr.domain.model.DiscountData;
import se.johan.rentr.domain.source.WeatherSource;
import se.johan.rentr.domain.store.AgeCategoryStore;
import se.johan.rentr.domain.store.CartStore;
import se.johan.rentr.domain.store.EquipmentItemStore;

/**
 * Service class for managing Cart operations.
 */
@RequiredArgsConstructor
@Service
public class CartService {

    /**
     * Cart Store for persisting and retrieving Cart data
     */
    private final CartStore cartStore;

    /**
     * Age Category Store for retrieving age category data
     */
    private final AgeCategoryStore ageCategoryStore;

    private final EquipmentItemStore equipmentItemStore;

    /**
     * Weather Source for retrieving weather data
     */
    private final WeatherSource weatherSource;

    /**
     * Get Cart by ID
     * 
     * @param cartId ID of the Cart
     * @return A Cart with calculated total amount
     */
    public Cart getCart(String cartId) {
        Cart cart = cartStore.getCart(cartId);
        cart.calculateTotalAmount();
        return cart;
    }

    /**
     * Save a new Cart
     * 
     * @param cart The Cart to save
     * @return The saved Cart, potentially with updated fields
     */
    public Cart saveCart(Cart cart, DiscountData discountData) {
        cart.setId(UUID.randomUUID().toString());
        cart.getCartItems().forEach(cartItem -> {
            // Resolve EquipmentItem from store based on equipment type and age category
            String equipmentTypeId = cartItem.getEquipmentItem().getEquipmentType().getId();
            String ageCategoryId = cartItem.getEquipmentItem().getAgeCategory().getId();
            if (cartItem.getAgeInYears() > 0) {
                // Find appropriate age category based on age in years
                List<AgeCategory> ageCategories = ageCategoryStore.getAllAgeCategories();
                for (var ageCategory : ageCategories) {
                    if (cartItem.getAgeInYears() >= ageCategory.getMinAge() &&
                        cartItem.getAgeInYears() <= ageCategory.getMaxAge()) {
                        ageCategoryId = ageCategory.getId();
                        break;
                    }
                }
            }
            var equipmentItem = equipmentItemStore.getEquipmentItemByTypeAndAgeCategory(equipmentTypeId, ageCategoryId);
            cartItem.setEquipmentItem(equipmentItem);
        });

        calculateDiscounts(cart, discountData);
        cart.calculateTotalAmount();
        
        cartStore.saveCart(cart);

        return cart;
    }

    /**
     * Calculate total amount for the Cart based on the contents and discount data
     * 
     * @param Cart cart The Cart to apply discounts to
     * @return A MonetaryAmount representing the total amount after discounts.
     */
    public void calculateDiscounts(Cart cart, DiscountData discountData) {
        if (discountData == null || discountData.getLocation() == null) {
            return;
        }
        
        // Get the lowest and highest age categories
        List<AgeCategory> ageCategories = ageCategoryStore.getAllAgeCategories();
        AgeCategory lowestAgeCategory = ageCategories.stream()
                .min((a, b) -> Integer.compare(a.getMinAge(), b.getMinAge()))
                .orElseThrow(() -> new IllegalStateException("No age categories found"));

        AgeCategory highestAgeCategory = ageCategories.stream()
                .max((a, b) -> Integer.compare(a.getMaxAge(), b.getMaxAge()))
                .orElseThrow(() -> new IllegalStateException("No age categories found"));

        // Get current temperature from weather source
        double currentTemperature = weatherSource.getCurrentTemperatureCelsius(discountData.getLocation());

        // Calculate discounts based on age categories and temperature
        for (var item : cart.getCartItems()) {

            if (item.getEquipmentItem().getAgeCategory().equals(lowestAgeCategory) && 
                currentTemperature < 14.0) {
                // Apply 100% discount for lowest age category if temperature > 14C
                item.setDiscountPercentage(BigDecimal.valueOf(100));
            }

            if (item.getEquipmentItem().getAgeCategory().equals(highestAgeCategory) && 
                currentTemperature > 18.0) {
                // Apply 40% discount for highest age category if temperature > 18C
                item.setDiscountPercentage(BigDecimal.valueOf(40));
            }
        }
    }
}
