package com.know.hexagonalarchitecture.jparepository.product;

import com.know.hexagonalarchitecture.jparepository.DataMapper;
import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.product.model.ProductBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductRepositoryAdapterTest {

    @InjectMocks
    private ProductRepositoryAdapter adapter;
    @Mock
    private ProductDataRepository repository;
    @Mock
    private DataMapper mapper;
    @Test
    public void shouldSaveProduct(){

        when(repository.save(any()))
                .thenReturn(  new ProductData());

        when(mapper.toData((Product) any()))
                .thenReturn( new ProductData());

        when(mapper.toEntity((ProductData) any()))
                .thenReturn(new ProductBuilder().build());

        assertNotNull(adapter.saveProduct( new ProductBuilder().build()));
    }
    
    @Test
    public void shouldShowAllProducts(){
        
        when(repository.findAll())
                .thenReturn(Collections.singletonList(new ProductData()));
        
        assertNotNull(adapter.listProducts());
    }


    @Test
    public void shoulOneProduct(){

        when(repository.findById(anyLong()))
                .thenReturn(Optional.of(new ProductData()));

        when(mapper.toEntity((ProductData) any()))
                .thenReturn(new ProductBuilder().build());

        assertNotNull(adapter.findOneProduct(1l));
    }

    @Test
    public void shouldUpdateProduct(){

        when(repository.findById(anyLong()))
                .thenReturn(Optional.of(new ProductData()));

        when(repository.save(any()))
                .thenReturn(new ProductData());

        when(mapper.toEntity((ProductData) any()))
                .thenReturn(new ProductBuilder().build());


        assertNotNull(adapter.updateProduct(new ProductBuilder().withId(1L).withIdUser(1L)
                        .withName("xx").withPrice(200.0).build(),1L));

    }


}