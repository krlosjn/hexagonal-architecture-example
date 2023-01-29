package com.know.hexagonalarchitecture.usecase.product;


import com.know.hexagonalarchitecture.product.usecasedomain.DeleteProductUseCaseDomain;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductUseCase {

    private final DeleteProductUseCaseDomain deleteProductUseCaseDomain;

    public DeleteProductUseCase(DeleteProductUseCaseDomain DeleteProductUseCaseDomain) {
        this.deleteProductUseCaseDomain = DeleteProductUseCaseDomain;
    }

    public String execute(Long id){
        return this.deleteProductUseCaseDomain.deleteProductCurrent(id);
    }
}
