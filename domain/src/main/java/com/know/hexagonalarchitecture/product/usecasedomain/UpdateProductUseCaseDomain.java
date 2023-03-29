package com.know.hexagonalarchitecture.product.usecasedomain;

import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.ports.ProductRepository;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import com.know.hexagonalarchitecture.utils.exception.BusinessExceptionMessage;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductUseCaseDomain {

    private final ProductRepository repository;

    public UpdateProductUseCaseDomain(ProductRepository repository){
        this.repository=repository;
    }


    public Product updateProduct(Product product, Long id) throws BusinessException {
        validateProductNotFound(id);
        return this.repository.updateProduct(product,id);
    }

    public void validateProductNotFound(Long id) throws BusinessException {
        if(!this.repository.productExist(id)){
            throw new BusinessException(BusinessExceptionMessage.PRODUCTCANTBEUPDATE.toString());
        }
    }

}
