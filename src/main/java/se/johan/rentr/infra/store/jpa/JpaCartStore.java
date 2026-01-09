package se.johan.rentr.infra.store.jpa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import se.johan.rentr.domain.model.Cart;
import se.johan.rentr.domain.store.CartStore;
import se.johan.rentr.infra.store.jpa.entity.CartEntity;
import se.johan.rentr.infra.store.jpa.entity.CartItemEntity;
import se.johan.rentr.infra.store.jpa.entity.EquipmentItemEntity;
import se.johan.rentr.infra.store.jpa.entity.mapper.CartEntityMapper;
import se.johan.rentr.infra.store.jpa.repository.CartItemRepository;
import se.johan.rentr.infra.store.jpa.repository.CartRepository;
import se.johan.rentr.infra.store.jpa.repository.EquipmentItemRepository;

/**
 * JPA implementation of the CartStore.
 */
@RequiredArgsConstructor
@Service
@Transactional
public class JpaCartStore implements CartStore {
    /**
     * Repository for CartEntity.
     */
    private final CartRepository cartRepository;

    /**
     * Repository for CartItemEntity.
     */
    private final CartItemRepository cartItemRepository;

    /**
     * Repository for EquipmentItemEntity.
     */
    private final EquipmentItemRepository equipmentItemRepository;

    /**
     * Mapper for CartEntity and Cart domain model.
     */
    private final CartEntityMapper cartEntityMapper;

    @Override
    public Cart getCart(String cartId) {
        return cartEntityMapper.toDomain(cartRepository.findById(cartId));
    }

    @Override
    public Cart saveCart(Cart cart) {
        CartEntity cartEntity = cartEntityMapper.toEntity(cart);


        for (var cartItemEntity : cartEntity.getCartItems()) {
            resolveCartItemEntity(cartItemEntity);
        }
        CartEntity savedCartEntity = cartRepository.save(cartEntity);

        for(var cartItemEntity : savedCartEntity.getCartItems()) {
            cartItemEntity.setCart(savedCartEntity);
            cartItemRepository.save(cartItemEntity);
        }
    
        return cartEntityMapper.toDomain(savedCartEntity);
    }

    /**
     * Resolve and set the EquipmentItemEntity for the given CartItemEntity.
     * 
     * @param cartItemEntity The CartItemEntity to resolve
     */
    private void resolveCartItemEntity(CartItemEntity cartItemEntity) {
        EquipmentItemEntity equipmentItemEntity = equipmentItemRepository.findById(
                cartItemEntity.getEquipmentItem().getId());
        cartItemEntity.setEquipmentItem(equipmentItemEntity);
    }
}
