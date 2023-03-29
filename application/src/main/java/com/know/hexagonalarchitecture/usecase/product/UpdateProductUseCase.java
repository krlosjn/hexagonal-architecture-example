package com.know.hexagonalarchitecture.usecase.product;


import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.usecasedomain.UpdateProductUseCaseDomain;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductUseCase {

    private final UpdateProductUseCaseDomain updateProductUseCaseDomain;

    public UpdateProductUseCase(UpdateProductUseCaseDomain updateProductUseCaseDomain) {
        this.updateProductUseCaseDomain = updateProductUseCaseDomain;
    }

    public Product execute(Product product, Long id) throws BusinessException {
        return this.updateProductUseCaseDomain.updateProduct(product,id);
    }

}
