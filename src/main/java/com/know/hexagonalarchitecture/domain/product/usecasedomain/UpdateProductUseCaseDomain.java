package com.know.hexagonalarchitecture.domain.product.usecasedomain;

import com.know.hexagonalarchitecture.domain.product.exception.ProductNotFoundException;
import com.know.hexagonalarchitecture.domain.product.model.Product;
import com.know.hexagonalarchitecture.domain.product.ports.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductUseCaseDomain {

    public static final String PRODUCT_CANTBE_UPDATE = "El producto no se puede actualizar , no está registrado";
    private final ProductRepository repository;

    public UpdateProductUseCaseDomain(ProductRepository repository){
        this.repository=repository;
    }


    public Product updateProduct(Product product, Long id){
        validateProductNotFound(id);
        return this.repository.updateProduct(product,id);
    }

    public void validateProductNotFound(Long id){
        if(!this.repository.productExist(id)){
            throw new ProductNotFoundException(PRODUCT_CANTBE_UPDATE);
        }
    }



}
