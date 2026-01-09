package se.johan.rentr.access.api.rest.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import se.johan.rentr.access.api.rest.v1.dto.CartDto;
import se.johan.rentr.access.api.rest.v1.dto.CartWrapperDto;
import se.johan.rentr.access.api.rest.v1.dto.mapper.CartDtoMapper;
import se.johan.rentr.access.api.rest.v1.dto.mapper.DiscountDataDtoMapper;
import se.johan.rentr.domain.service.CartService;

/**
 * REST controller for managing shopping carts.
 */
@RestController
@RequiredArgsConstructor
public class CartController {

    /**
     * Service for cart operations.
     */
    private final CartService cartService;

    /**
     * Mapper for Cart DTOs.
     */
    private final CartDtoMapper cartDtoMapper;

    /**
     * Mapper for DiscountData DTOs.
     */
    private final DiscountDataDtoMapper discountDataDtoMapper;
    
    /**
     * Get Cart by ID
     * 
     * @param id ID of the Cart
     * @return The Cart DTO
     */
    @GetMapping("/cart/{id}")
    public CartDto getCart(@PathVariable String id) {
        return cartDtoMapper.toDto(cartService.getCart(id));
    }

    /**
     * Create a new Cart
     * 
     * @param cartWrapperDto The Cart wrapper DTO containing cart and discount data
     * @return The created Cart DTO
     */
    @PostMapping("/cart")
    public CartDto createCart(@RequestBody CartWrapperDto cartWrapperDto) {

        return cartDtoMapper.toDto(cartService.saveCart(
                cartDtoMapper.toDomain(cartWrapperDto.getCart()),
                discountDataDtoMapper.toDomain(cartWrapperDto.getDiscountData())));
    }
}
