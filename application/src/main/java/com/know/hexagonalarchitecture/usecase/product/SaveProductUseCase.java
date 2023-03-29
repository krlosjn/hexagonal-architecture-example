package com.know.hexagonalarchitecture.usecase.product;


import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.usecasedomain.SaveProductUseCaseDomain;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class SaveProductUseCase {

    private final SaveProductUseCaseDomain saveProductUseCaseDomain;

    public SaveProductUseCase(SaveProductUseCaseDomain saveProductUseCaseDomain){
        this.saveProductUseCaseDomain=saveProductUseCaseDomain;
    }

    public Product execute(Product product) throws BusinessException {
        return this.saveProductUseCaseDomain.saveProduct(product);
    }
}
