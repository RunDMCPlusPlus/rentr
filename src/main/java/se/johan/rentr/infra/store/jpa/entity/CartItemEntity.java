package se.johan.rentr.infra.store.jpa.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;
import se.johan.rentr.domain.model.Cart;

/**
 * JPA Entity representing a Cart Item.
 */
@Data
@Entity
@Table(name = "cart_item")
public class CartItemEntity {
    /**
     * Database ID of the Cart Item.
     */
    @Id
    @Column(name = "database_id")
    @GeneratedValue(generator = "cart_item_sequence")
    @SequenceGenerator(name = "cart_item_sequence", sequenceName = "cart_item_database_id_seq", allocationSize = 1)
    private long databaseId;

    /**
     * The Equipment Item Entity associated with this Cart Item.
     */
    @ManyToOne
    @JoinColumn(name = "equipment_item_database_id")
    private EquipmentItemEntity equipmentItem;

    /**
     * The Cart Entity this Cart Item belongs to.
     */
    @ManyToOne
    @JoinColumn(name = "cart_database_id")
    private CartEntity cart;


    /**
     * Discount percentage applied to the Cart Item.
     */
    @Column(name = "discount_percentage")
    private BigDecimal discountPercentage;

    /**
     * Quantity of the Cart Item.
     */
    @Column(name = "quantity")
    private int quantity;
}
