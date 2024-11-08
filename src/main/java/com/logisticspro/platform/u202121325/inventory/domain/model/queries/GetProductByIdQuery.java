package com.logisticspro.platform.u202121325.inventory.domain.model.queries;

public record GetProductByIdQuery (Integer productId) {
    public GetProductByIdQuery {
        if (productId == null) {
            throw new IllegalArgumentException("productId cannot be null");
        }
    }
}
