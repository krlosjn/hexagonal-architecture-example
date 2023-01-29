package com.know.hexagonalarchitecture.product.ports;

import com.know.hexagonalarchitecture.product.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> listProducts();
    Product saveProduct(Product product);
    Product findOneProduct(Long id);
    boolean productExist(Long id);
    Product updateProduct(Product product,Long id);
    void deleteProduct(Long id);
}
