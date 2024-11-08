package com.logisticspro.platform.u202121325.inventory.domain.model.queries;

public record GetProductReviewByProductIdQuery(Integer productId) {
    public GetProductReviewByProductIdQuery {
        if (productId == null) {
            throw new IllegalArgumentException("productId cannot be null");
        }
    }
}
