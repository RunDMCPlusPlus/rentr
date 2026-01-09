package se.johan.rentr.access.api.rest.v1.dto;

import lombok.Data;

/**
 * DTO representing a geographical location.
 */
@Data
public class LocationDto {
    /**
     * Latitude of the location.
     */
    private double latitude;
    
    /**
     * Longitude of the location.
     */
    private double longitude;
}
