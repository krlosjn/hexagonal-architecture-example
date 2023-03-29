package com.know.hexagonalarchitecture.product.usecasedomain;

import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.model.ProductBuilder;
import com.know.hexagonalarchitecture.product.ports.ProductRepository;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import com.know.hexagonalarchitecture.utils.exception.BusinessExceptionMessage;
import org.springframework.stereotype.Service;

import static com.know.hexagonalarchitecture.utils.ValidateArgument.validateMandatory;
import static com.know.hexagonalarchitecture.utils.ValidateArgument.validatePrice;


@Service
public class SaveProductUseCaseDomain {


    private final ProductRepository repository;

    public SaveProductUseCaseDomain(ProductRepository repository){
        this.repository=repository;
    }

    public Product saveProduct(Product product) throws BusinessException {
        validateProductRepeat(product);
        validateMandatory(product.getName());
        validatePrice(product.getPrice());

        Product productCurrent = new ProductBuilder().withId(product.getIdProduct())
                .withIdUser(product.getIdUser())
                .withName(product.getName())
                .withPrice(product.getPrice())
                .build();

        return this.repository.saveProduct(productCurrent);
    }


    private void validateProductRepeat(Product product) throws BusinessException {
        if(repository.productExist(product.getIdProduct())){
            throw new BusinessException(BusinessExceptionMessage.PRODUCTREPEAT.toString() + product.getIdProduct() );
        }
    }
}
