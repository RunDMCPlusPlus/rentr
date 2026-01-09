package se.johan.rentr.domain.model;

import javax.money.MonetaryAmount;

import lombok.Builder;
import lombok.Data;

/**
 * Domain model representing an Equipment Item.
 */
@Builder
@Data
public class EquipmentItem {
    /**
     * ID of the Equipment Item.
     */
    private String id;

    /**
     * Name of the Equipment Item.
     */
    private AgeCategory ageCategory;

    /**
     * Type of the Equipment Item.
     */
    private EquipmentType equipmentType;

    /**
     * Price per day for renting the Equipment Item.
     */
    private MonetaryAmount pricePerDay;
}
