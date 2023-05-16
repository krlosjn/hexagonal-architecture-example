package com.know.hexagonalarchitecture.usecase.product;


import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.ports.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class FindOneProductUseCase {

    private final ProductRepository repository;

    public FindOneProductUseCase(ProductRepository repository){
        this.repository=repository;
    }

    public Product execute(Long id){
        return this.repository.findOneProduct(id);
    }

}
