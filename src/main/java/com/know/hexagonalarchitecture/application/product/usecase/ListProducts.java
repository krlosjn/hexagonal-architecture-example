package com.know.hexagonalarchitecture.application.product.usecase;

import com.know.hexagonalarchitecture.domain.product.model.Product;
import com.know.hexagonalarchitecture.domain.product.ports.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListProducts {
    private final ProductRepository repository;
    public ListProducts(ProductRepository repository){
        this.repository=repository;
    }

    public List<Product> execute(){
        return this.repository.listProducts();
    }

}
