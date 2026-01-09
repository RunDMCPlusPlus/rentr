package se.johan.rentr.infra.source.yr;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import se.johan.rentr.domain.model.Location;
import se.johan.rentr.domain.source.WeatherSource;

/**
 * Weather source implementation that fetches weather data from the Yr weather API.
 */
@Component
public class YrWeatherSource implements WeatherSource {
    /**
     * Rest client for accessing the Yr weather API.
     */
    RestClient restClient;

    /**
     * Constructs a YrWeatherSource with a RestClient configured for the Yr weather API.
     */
    public YrWeatherSource() {
        this.restClient = RestClient.builder()
                .baseUrl("https://api.met.no/weatherapi/locationforecast/2.0/compact.json")
                .build();
    }

    @Override
    public double getCurrentTemperatureCelsius(Location location) {
        // YR API expects latitude and longitude formatted to 4 decimal places
        String latStr = String.format("%.4f", location.getLatitude());
        String lonStr = String.format("%.4f", location.getLongitude());

        WeatherResponse response = restClient.get()
            .uri(uriBuilder -> uriBuilder
                .queryParam("altitude", "0")
                .queryParam("lat", latStr)
                .queryParam("lon", lonStr)
                .build())
            .retrieve()
            .body(WeatherResponse.class);

        return response.properties().timeseries()[0].data().instant().details().air_temperature();
    }

    /**
     * Data classes for deserializing the Yr weather API response.
     */
    record WeatherResponse(
        Properties properties
    ) {
        record Properties(
            Timeseries[] timeseries
        ) {
            record Timeseries(
                String time,
                Data data
            ) {
                record Data(
                    InstantDetails instant
                ) {
                    record InstantDetails(
                        Details details
                    ) {
                        record Details(
                            double air_temperature
                        ) {
                        }
                    }
                }
            }
        }
    }

}
