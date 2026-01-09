package se.johan.rentr.domain.source;

import se.johan.rentr.domain.model.Location;

/**
 * Interface representing a weather data source.
 */
public interface WeatherSource {
    /**
     * Get the current temperature in Celsius for a given location.
     * 
     * @param location The geographical location
     * @return The current temperature in Celsius
     */
    double getCurrentTemperatureCelsius(Location location);
}
