package se.johan.rentr.domain.model;

import lombok.Builder;
import lombok.Data;

/**
 * Domain model representing a geographical Location.
 */
@Builder
@Data
public class Location {
    /**
     * Latitude of the Location.
     */
    double latitude;
    
    /**
     * Longitude of the Location.
     */
    double longitude;
}
