package com.know.hexagonalarchitecture.product.usecasedomain;

import com.know.hexagonalarchitecture.product.exception.ProductRepeatException;
import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.ports.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class SaveProductUseCaseDomain {

    public static final String PRODUCT_REPEAT = "El producto ya está registrado ";
    private final ProductRepository repository;

    public SaveProductUseCaseDomain(ProductRepository repository){
        this.repository=repository;
    }

    public Product saveProduct(Product product){
        validateProductRepeat(product);
        return this.repository.saveProduct(product);
    }


    private void validateProductRepeat(Product product){
        if(repository.productExist(product.getId())){
            throw new ProductRepeatException(PRODUCT_REPEAT + product.getId() );
        }
    }
}
