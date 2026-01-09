package se.johan.rentr.domain.model;

import lombok.Builder;
import lombok.Data;

/**
 * Domain model representing an age category.
 */
@Builder(toBuilder = true)
@Data
public class AgeCategory {
    /**
     * ID of the Age Category.
     */
    private String id;

    /**
     * Name of the Age Category.
     */
    private String name; 
    
    /**
     * Minimum age for the Age Category.
     */
    private int minAge; 
    
    /**
     * Maximum age for the Age Category.
     */
    private int maxAge; 
}
