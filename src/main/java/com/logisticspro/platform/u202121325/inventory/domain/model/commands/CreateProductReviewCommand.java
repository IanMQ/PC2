package com.logisticspro.platform.u202121325.inventory.domain.model.commands;

import com.logisticspro.platform.u202121325.inventory.domain.model.aggregates.Product;
import com.logisticspro.platform.u202121325.inventory.domain.model.valueobjects.ProductReviewCriterion;

public record CreateProductReviewCommand (
        String userEmail,
        Integer rating,
        ProductReviewCriterion reviewCriterion,
        String comment,
        Product product
){
    public CreateProductReviewCommand {
        if (userEmail == null || userEmail.isEmpty()) {
            throw new IllegalArgumentException("User email cannot be null or empty");
        }
        if (rating == null || rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        if (reviewCriterion == null) {
            throw new IllegalArgumentException("Review criterion cannot be null");
        }
        if (comment == null || comment.isEmpty()) {
            throw new IllegalArgumentException("Comment cannot be null or empty");
        }
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
    }
}
