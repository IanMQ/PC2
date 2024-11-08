package com.logisticspro.platform.u202121325.inventory.domain.model.commands;

import com.logisticspro.platform.u202121325.inventory.domain.model.aggregates.ProductReview;
import com.logisticspro.platform.u202121325.inventory.domain.model.valueobjects.ProductStatus;

import java.util.List;

public record CreateProductCommand(
        String name,
        String description,
        ProductStatus status

) {
    public CreateProductCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
    }
}
