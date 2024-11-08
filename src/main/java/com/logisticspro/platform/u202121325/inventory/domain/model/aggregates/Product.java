package com.logisticspro.platform.u202121325.inventory.domain.model.aggregates;


import com.logisticspro.platform.u202121325.inventory.domain.model.valueobjects.ProductStatus;
import com.logisticspro.platform.u202121325.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

// Marca la clase como una entidad y asigna la tabla "product" en la base de datos
@Entity
@Table(name = "`product`") // Las comillas invertidas se usan para evitar conflictos con "product", que es una palabra reservada en SQL
@Getter
@Setter
public class Product extends AuditableAbstractAggregateRoot<Product> {

    @Column(name = "product_code", updatable = false, nullable = false, unique = true)
    private UUID productCode = UUID.randomUUID();

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductStatus status;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductReview> reviews;
}
