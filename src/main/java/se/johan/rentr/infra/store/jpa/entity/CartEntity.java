package se.johan.rentr.infra.store.jpa.entity;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * JPA Entity representing a Cart.
 */
@Data
@Entity
@Table(name = "cart")
public class CartEntity {
    /**
     * Database ID of the Cart.
     */
    @Id
    @Column(name = "database_id")
    @GeneratedValue(generator = "cart_sequence")
    @SequenceGenerator(name = "cart_sequence", sequenceName = "cart_database_id_seq", allocationSize = 1)
    private long databaseId;

    /**
     * ID of the Cart.
     */
    @Column(name = "id")
    private String id;

    /**
     * Last updated timestamp of the Cart.
     */
    @Column(name = "last_updated_at")
    private Instant lastUpdatedAt;

    /**
     * Collection of Cart Items associated with the Cart.
     */
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "cart_database_id")
    private List<CartItemEntity> cartItems;
}
