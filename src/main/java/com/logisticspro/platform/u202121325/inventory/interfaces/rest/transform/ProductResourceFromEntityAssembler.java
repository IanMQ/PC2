package com.logisticspro.platform.u202121325.inventory.interfaces.rest.transform;

import com.logisticspro.platform.u202121325.inventory.domain.model.aggregates.Product;
import com.logisticspro.platform.u202121325.inventory.interfaces.rest.resources.ProductResource;

public class ProductResourceFromEntityAssembler {
    public static ProductResource fromEntity(Product product) {
        return new ProductResource(
                product.getId(), product.getName(),
                product.getDescription(), product.getStatus());
    }
}
