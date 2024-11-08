package com.logisticspro.platform.u202121325.inventory.interfaces.rest.resources;

import com.logisticspro.platform.u202121325.inventory.domain.model.valueobjects.ProductStatus;


import java.util.List;

public record ProductResource(
        Integer id,
        String name,
        String description,
        ProductStatus status
) {
}
