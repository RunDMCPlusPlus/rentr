package se.johan.rentr.domain.model;

import lombok.Builder;
import lombok.Data;

/**
 * Domain model representing an Equipment Type.
 */
@Builder
@Data
public class EquipmentType {
    /**
     * ID of the Equipment Type.
     */
    private String id;

    /**
     * Name of the Equipment Type.
     */
    private String name;
}
        