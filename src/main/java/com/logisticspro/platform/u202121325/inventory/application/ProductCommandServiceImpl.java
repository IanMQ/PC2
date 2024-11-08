package com.logisticspro.platform.u202121325.inventory.application;

import com.logisticspro.platform.u202121325.inventory.domain.model.aggregates.Product;
import com.logisticspro.platform.u202121325.inventory.domain.model.commands.CreateProductCommand;
import com.logisticspro.platform.u202121325.inventory.domain.services.ProductCommandService;
import com.logisticspro.platform.u202121325.inventory.infraestructure.persistance.jpa.repositories.ProductRepository;
import com.logisticspro.platform.u202121325.inventory.infraestructure.persistance.jpa.repositories.ProductReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {
    private final ProductReviewRepository productReviewRepository;
    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductReviewRepository productReviewRepository, ProductRepository productRepository) {
        this.productReviewRepository = productReviewRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Optional<Product> handle(CreateProductCommand command) {
        var product = new Product();
        product.setName(command.name());
        product.setDescription(command.description());
        product.setStatus(command.status());

        var createdProduct = productRepository.save(product);

        return Optional.of(createdProduct);
    }

}
