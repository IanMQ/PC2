package com.logisticspro.platform.u202121325.inventory.domain.model.aggregates;

import com.logisticspro.platform.u202121325.inventory.domain.model.valueobjects.ProductReviewCriterion;
import com.logisticspro.platform.u202121325.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "`product_review`")
@Getter
@Setter
public class ProductReview extends AuditableAbstractAggregateRoot<ProductReview> {

    @Column(nullable = false, length = 50)
    private String userEmail;

    @Column(nullable = false)
    private Integer rating;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductReviewCriterion reviewCriterion;

    @Column(length = 500)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}