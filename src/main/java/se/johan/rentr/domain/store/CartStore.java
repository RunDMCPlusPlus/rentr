package se.johan.rentr.domain.store;

import se.johan.rentr.domain.model.Cart;

/**
 * Store interface for managing Carts.
 */
public interface CartStore {
    /**
     * Get Cart by ID
     * 
     * @param cartId ID of the Cart
     * @return The Cart
     */
    Cart getCart(String cartId);

    /**
     * Save a new Cart
     * 
     * @param cart The Cart to save
     * @return The saved Cart
     */
    Cart saveCart(Cart cart);
}
