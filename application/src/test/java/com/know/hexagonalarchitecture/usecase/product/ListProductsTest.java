package com.know.hexagonalarchitecture.usecase.product;

import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.model.ProductBuilder;
import com.know.hexagonalarchitecture.product.ports.ProductRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListProductsTest extends TestCase {

    @InjectMocks
    private ListProductsUseCase listProductsUseCase;

    @Mock
    private ProductRepository repository;

    @Test
    public void shouldFindAllProducts(){

        Product product = new ProductBuilder().withId(1L)
                        .withName("CAMISA")
                                .withPrice(200.0)
                                        .withIdUser(1L).build();
        when(repository.listProducts())
                .thenReturn(Collections.singletonList(product));

        assertNotNull(listProductsUseCase.execute());
    }

}