package com.logisticspro.platform.u202121325.inventory.interfaces.rest.transform;

import com.logisticspro.platform.u202121325.inventory.domain.model.commands.CreateProductCommand;
import com.logisticspro.platform.u202121325.inventory.interfaces.rest.resources.ProductResource;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommandFromResource(ProductResource resource) {
        return new CreateProductCommand(
                resource.name(),
                resource.description(),
                resource.status()
        );
    }
}
