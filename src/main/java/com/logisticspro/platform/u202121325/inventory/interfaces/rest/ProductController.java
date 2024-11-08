package com.logisticspro.platform.u202121325.inventory.interfaces.rest;

import com.logisticspro.platform.u202121325.inventory.domain.model.aggregates.Product;

import com.logisticspro.platform.u202121325.inventory.domain.model.queries.GetProductByIdQuery;
import com.logisticspro.platform.u202121325.inventory.domain.services.ProductCommandService;
import com.logisticspro.platform.u202121325.inventory.domain.services.ProductQueryService;
import com.logisticspro.platform.u202121325.inventory.interfaces.rest.resources.ProductResource;
import com.logisticspro.platform.u202121325.inventory.interfaces.rest.transform.CreateProductCommandFromResourceAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductQueryService productQueryService;
    private final ProductCommandService productCommandService;

    public ProductController(ProductQueryService productQueryService, ProductCommandService productCommandService) {
        this.productQueryService = productQueryService;
        this.productCommandService = productCommandService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductResource productResource) {
        var createProductCommand = CreateProductCommandFromResourceAssembler.toCommandFromResource(productResource);
        var product = productCommandService.handle(createProductCommand);
        if (product.isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(product.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Optional<Product> product = productQueryService.handle(new GetProductByIdQuery(id));
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
