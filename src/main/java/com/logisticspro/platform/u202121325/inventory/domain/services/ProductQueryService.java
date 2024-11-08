package com.logisticspro.platform.u202121325.inventory.domain.services;

import com.logisticspro.platform.u202121325.inventory.domain.model.aggregates.Product;
import com.logisticspro.platform.u202121325.inventory.domain.model.queries.GetProductByIdQuery;

import java.util.Optional;

public interface ProductQueryService {
    Optional<Product> handle(GetProductByIdQuery query);
}
