package com.know.hexagonalarchitecture.application.product.usecase;

import com.know.hexagonalarchitecture.domain.product.model.Product;
import com.know.hexagonalarchitecture.domain.product.usecasedomain.UpdateProductUseCaseDomain;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductUseCase {

    private final UpdateProductUseCaseDomain updateProductUseCaseDomain;

    public UpdateProductUseCase(UpdateProductUseCaseDomain updateProductUseCaseDomain) {
        this.updateProductUseCaseDomain = updateProductUseCaseDomain;
    }

    public Product execute(Product product, Long id){
        return this.updateProductUseCaseDomain.updateProduct(product,id);
    }

}
