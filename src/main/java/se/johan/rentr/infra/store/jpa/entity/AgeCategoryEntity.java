package se.johan.rentr.infra.store.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * JPA Entity representing an Age Category.
 */
@Data
@Entity
@Table(name = "age_category")
public class AgeCategoryEntity {
    /**
     * Database ID of the Age Category.
     */
    @Id
    @Column(name = "database_id")
    @GeneratedValue(generator = "age_category_sequence")
    @SequenceGenerator(name = "age_category_sequence", sequenceName = "age_category_database_id_seq", allocationSize = 1)
    private long databaseId;

    /**
     * ID of the Age Category.
     */
    @Column(name = "id")
    private String id;

    /**
     * Name of the Age Category.
     */
    @Column(name = "name")
    private String name;

    /**
     * Minimum age for the Age Category.
     */
    @Column(name = "min_age")
    private int minAge;

    /**
     * Maximum age for the Age Category.
     */
    @Column(name = "max_age")
    private int maxAge;
}
