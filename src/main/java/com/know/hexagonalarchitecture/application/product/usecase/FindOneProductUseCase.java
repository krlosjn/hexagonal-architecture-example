package com.know.hexagonalarchitecture.application.product.usecase;

import com.know.hexagonalarchitecture.domain.product.model.Product;
import com.know.hexagonalarchitecture.domain.product.ports.ProductRepository;
import org.springframework.stereotype.Component;


@Component
public class FindOneProductUseCase {

    private final ProductRepository repository;

    public FindOneProductUseCase(ProductRepository repository){
        this.repository=repository;
    }

    public Product execute(Long id){
        return this.repository.findOneProduct(id);
    }

}
