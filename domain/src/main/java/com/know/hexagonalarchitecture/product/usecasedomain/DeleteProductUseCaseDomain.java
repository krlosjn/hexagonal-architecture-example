package com.know.hexagonalarchitecture.product.usecasedomain;

import com.know.hexagonalarchitecture.product.ports.ProductRepository;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import com.know.hexagonalarchitecture.utils.exception.BusinessExceptionMessage;


public class DeleteProductUseCaseDomain {

    private final ProductRepository repository;

    public DeleteProductUseCaseDomain(ProductRepository repository) {
        this.repository = repository;
    }

    public String deleteProductCurrent(Long id) throws BusinessException {
        if(!this.repository.productExist(id)){
            throw new BusinessException(BusinessExceptionMessage.PRODUCTCANTBEDROP.toString());
        }
        this.repository.deleteProduct(id);
        return "El producto con id " + id + " ha sido eliminado";

    }

}
