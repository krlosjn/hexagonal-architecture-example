package com.know.hexagonalarchitecture.jparepository.product;


import com.know.hexagonalarchitecture.jparepository.DataMapper;
import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.ports.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductDataRepository repository;

    private final DataMapper mapper;

    public ProductRepositoryAdapter(ProductDataRepository repository, DataMapper mapper){
        this.repository=repository;
        this.mapper=mapper;
    }

    @Override
    public List<Product> listProducts() {
        List<Product> lsProduct = new ArrayList<>();
         this.repository.findAll().stream().forEach(rs->lsProduct.add(this.mapper.toEntity(rs)));
         return lsProduct;
    }

    @Override
    public Product saveProduct(Product product) {
        return this.mapper.toEntity(this.repository.save(this.mapper.toData(product)));
    }

    @Override
    public Product findOneProduct(Long id) {
        return  this.mapper.toEntity(this.repository.findById(id).get());
    }

    @Override
    public boolean productExist(Long id) {
        if(this.repository.existsProductByIdProduct(id)){
            return true;
        }
        return false;
    }

    @Override
    public Product updateProduct(Product productUp, Long id) {
       return this.repository.findById(id)
               .map(product->{
                   product.setName(productUp.getName());
                   product.setPrice(productUp.getPrice());
                  return this.mapper.toEntity(this.repository.save(product));
               }).orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {
        this.repository.deleteById(id);
    }
}
