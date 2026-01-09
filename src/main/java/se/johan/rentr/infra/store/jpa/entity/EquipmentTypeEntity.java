package se.johan.rentr.infra.store.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * JPA Entity representing an Equipment Type.
 */
@Data
@Entity
@Table(name = "equipment_type")
public class EquipmentTypeEntity {
    /**
     * Database ID of the Equipment Type.
     */
    @Id
    @Column(name = "database_id")
    @GeneratedValue(generator = "equipment_type_sequence")
    @SequenceGenerator(name = "equipment_type_sequence", sequenceName = "equipment_type_database_id_seq", allocationSize = 1)
    private long databaseId;

    /**
     * ID of the Equipment Type.
     */
    @Column(name = "id")
    private String id;

    /**
     * Name of the Equipment Type.
     */
    @Column(name = "name")
    private String name;
}
