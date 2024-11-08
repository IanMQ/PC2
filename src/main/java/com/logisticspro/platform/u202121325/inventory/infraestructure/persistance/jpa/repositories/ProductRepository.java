package com.logisticspro.platform.u202121325.inventory.infraestructure.persistance.jpa.repositories;

import com.logisticspro.platform.u202121325.inventory.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(Integer ProductId);
}
