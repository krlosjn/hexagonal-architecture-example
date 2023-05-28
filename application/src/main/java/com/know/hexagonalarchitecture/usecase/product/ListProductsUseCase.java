package com.know.hexagonalarchitecture.usecase.product;


import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.ports.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProductsUseCase {
    private final ProductRepository repository;
    public ListProductsUseCase(ProductRepository repository){
        this.repository=repository;
    }

    public List<Product> execute(){
        return this.repository.listProducts();
    }

}
