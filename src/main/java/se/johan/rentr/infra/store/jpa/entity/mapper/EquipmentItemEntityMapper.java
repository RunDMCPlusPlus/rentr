package se.johan.rentr.infra.store.jpa.entity.mapper;

import java.math.BigDecimal;

import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import se.johan.rentr.domain.model.EquipmentItem;
import se.johan.rentr.infra.store.jpa.entity.EquipmentItemEntity;

/**
 * Mapper interface for converting between EquipmentItem domain model and EquipmentItemEntity.
 */
@Mapper(uses = { AgeCategoryEntityMapper.class, EquipmentTypeEntityMapper.class})
public interface EquipmentItemEntityMapper {
    /**
     * Maps EquipmentItemEntity to EquipmentItem.
     * 
     * @param equipmentItemEntity The EquipmentItemEntity.
     * @return The corresponding EquipmentItem domain model.
     */
    EquipmentItem toDomain(EquipmentItemEntity equipmentItemEntity);

    /**
     * Maps EquipmentItem to EquipmentItemEntity.
     * 
     * @param equipmentItem The EquipmentItem domain model.
     * @return The corresponding EquipmentItemEntity.
     */
    @Mapping(target = "databaseId", ignore = true)
    EquipmentItemEntity toEntity(EquipmentItem equipmentItem);

    /**
     * Maps BigDecimal to MonetaryAmount.
     * 
     * @param amount The BigDecimal amount.
     * @return The corresponding MonetaryAmount with SEK as currency.
     */
    default MonetaryAmount map(BigDecimal amount) {
        if (amount == null) {
            return null;
        }

        // Assuming SEK as the currency right now, this can be made dynamic if needed
        return Money.of(amount, "SEK");
    }

    /**
     * Maps MonetaryAmount to BigDecimal.
     * 
     * @param amount The MonetaryAmount.
     * @return The corresponding BigDecimal value.
     */
    default BigDecimal map(MonetaryAmount amount) {
        if (amount == null) {
            return null;
        }
        return amount.getNumber().numberValue(BigDecimal.class);
    }
}
