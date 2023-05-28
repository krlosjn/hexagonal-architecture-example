package com.know.hexagonalarchitecture.usecase.product;


import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.model.ProductBuilder;
import com.know.hexagonalarchitecture.product.ports.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FindOneProductUseCaseTest {

    @InjectMocks
    private FindOneProductUseCase findOneProductUseCase;
    @Mock
    private ProductRepository repository;

    @Test
    public void shouldFindOneProduct(){

        Product product = new ProductBuilder().withId(1L).withPrice(200.0)
                        .withName("CAMISA").withIdUser(1L).build();

        when(repository.findOneProduct(anyLong()))
                .thenReturn(product);

        assertNotNull(findOneProductUseCase.execute(1L));

    }
}