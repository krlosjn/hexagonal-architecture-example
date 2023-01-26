package com.know.hexagonalarchitecture.application.product.usecase;

import com.know.hexagonalarchitecture.domain.product.model.Product;
import com.know.hexagonalarchitecture.domain.product.usecasedomain.SaveProductUseCaseDomain;
import org.springframework.stereotype.Component;

@Component
public class SaveProductUseCase {

    private final SaveProductUseCaseDomain saveProductUseCaseDomain;

    public SaveProductUseCase(SaveProductUseCaseDomain saveProductUseCaseDomain){
        this.saveProductUseCaseDomain=saveProductUseCaseDomain;
    }

    public Product execute(Product product){
        return this.saveProductUseCaseDomain.saveProduct(product);
    }
}
