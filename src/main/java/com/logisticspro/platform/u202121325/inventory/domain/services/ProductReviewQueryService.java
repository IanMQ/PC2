package com.logisticspro.platform.u202121325.inventory.domain.services;

import com.logisticspro.platform.u202121325.inventory.domain.model.aggregates.ProductReview;
import com.logisticspro.platform.u202121325.inventory.domain.model.queries.GetProductReviewByProductIdQuery;

import java.util.Optional;

public interface ProductReviewQueryService {
    Optional<ProductReview> handle(GetProductReviewByProductIdQuery query);
}
