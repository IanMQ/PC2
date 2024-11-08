package com.logisticspro.platform.u202121325.inventory.infraestructure.persistance.jpa.repositories;

import com.logisticspro.platform.u202121325.inventory.domain.model.aggregates.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
    Optional<ProductReview> findByProductId(Long ProductId);
}
