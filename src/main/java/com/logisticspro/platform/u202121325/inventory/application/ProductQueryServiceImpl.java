package com.logisticspro.platform.u202121325.inventory.application;

import com.logisticspro.platform.u202121325.inventory.domain.model.aggregates.Product;
import com.logisticspro.platform.u202121325.inventory.domain.model.queries.GetProductByIdQuery;
import com.logisticspro.platform.u202121325.inventory.domain.services.ProductQueryService;
import com.logisticspro.platform.u202121325.inventory.infraestructure.persistance.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {
    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {
        return productRepository.findById(query.productId());
    }
}
