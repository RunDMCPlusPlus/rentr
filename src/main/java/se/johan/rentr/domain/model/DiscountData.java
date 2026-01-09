package se.johan.rentr.domain.model;

import lombok.Builder;
import lombok.Data;

/**
 * Model representing discount data.
 */
@Builder
@Data
public class DiscountData {
    /**
     * Location of the user, used to determine weather conditions for discount eligibility.
     */
    Location location;
}
