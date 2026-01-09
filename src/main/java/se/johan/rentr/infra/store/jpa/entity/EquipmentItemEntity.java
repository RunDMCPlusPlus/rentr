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

/**
 * JPA Entity representing an Equipment Item.
 */
@Data
@Entity
@Table(name = "equipment_item")
public class EquipmentItemEntity {
    /**
     * Database ID of the Equipment Item.
     */
    @Id
    @Column(name = "database_id") 
    @GeneratedValue(generator = "equipment_item_sequence")
    @SequenceGenerator(name = "equipment_item_sequence", sequenceName = "equipment_item_database_id_seq", allocationSize = 1)
    private long databaseId;

    /**
     * ID of the Equipment Item.
     */
    @Column(name = "id")
    private String id;

    /**
     * Age Category of the Equipment Item.
     */
    @ManyToOne
    @JoinColumn(name = "age_category_database_id")
    private AgeCategoryEntity ageCategory;

    /**
     * Equipment Type of the Equipment Item.
     */
    @ManyToOne
    @JoinColumn(name = "equipment_type_database_id")
    private EquipmentTypeEntity equipmentType;

    /**
     * Price per day of the Equipment Item.
     */
    @Column(name = "price_per_day")
    private BigDecimal pricePerDay;
}
