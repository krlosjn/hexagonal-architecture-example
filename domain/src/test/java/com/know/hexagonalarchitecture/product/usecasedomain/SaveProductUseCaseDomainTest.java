package com.know.hexagonalarchitecture.product.usecasedomain;

import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.ports.ProductRepository;
import com.know.hexagonalarchitecture.testDataBuilder.ProductTestDataBuilder;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class SaveProductUseCaseDomainTest extends TestCase {

    @InjectMocks
    private SaveProductUseCaseDomain saveProductUseCaseDomain;

    @Mock
    private ProductRepository repository;

    @Test
    public void shouldSaveProduct() throws BusinessException {
        Product product = new ProductTestDataBuilder().build();

        when(repository.saveProduct(any()))
                .thenReturn(product);

        Product rs= saveProductUseCaseDomain.saveProduct(product);

        assertNotNull(rs);
    }



}