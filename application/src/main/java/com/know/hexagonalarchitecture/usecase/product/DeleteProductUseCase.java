package com.know.hexagonalarchitecture.usecase.product;


import com.know.hexagonalarchitecture.product.usecasedomain.DeleteProductUseCaseDomain;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import org.springframework.stereotype.Service;

@Service

public class DeleteProductUseCase {

    private final DeleteProductUseCaseDomain deleteProductUseCaseDomain;

    public DeleteProductUseCase(DeleteProductUseCaseDomain DeleteProductUseCaseDomain) {
        this.deleteProductUseCaseDomain = DeleteProductUseCaseDomain;
    }

    public String execute(Long id) throws BusinessException {
        return this.deleteProductUseCaseDomain.deleteProductCurrent(id);
    }
}
