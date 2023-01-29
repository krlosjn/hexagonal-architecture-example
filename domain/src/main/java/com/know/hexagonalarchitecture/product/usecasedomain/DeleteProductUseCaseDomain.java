package com.know.hexagonalarchitecture.product.usecasedomain;

import com.know.hexagonalarchitecture.product.exception.ProductNotFoundException;
import com.know.hexagonalarchitecture.product.ports.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductUseCaseDomain {

    public static final String PRODUCT_CANTBE_DROP = "El producto no se puede eliminar por que no existe";
    private final ProductRepository repository;

    public DeleteProductUseCaseDomain(ProductRepository repository) {
        this.repository = repository;
    }

    public String deleteProductCurrent(Long id) {
        if(!this.repository.productExist(id)){
            throw new ProductNotFoundException(PRODUCT_CANTBE_DROP);
        }
        this.repository.deleteProduct(id);
        return "El producto con id " + id + " ha sido eliminado";

    }
}
