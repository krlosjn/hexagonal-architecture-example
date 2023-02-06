package com.know.hexagonalarchitecture.jparepository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProductDataRepository extends JpaRepository<ProductData,Long> {
    @Transactional
    boolean existsProductByIdProduct(Long id);
}
