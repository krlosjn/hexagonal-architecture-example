package com.know.hexagonalarchitecture.controller.product;

import com.know.hexagonalarchitecture.helpers.dto.DataFactory;
import com.know.hexagonalarchitecture.helpers.dto.ObjectDto;
import com.know.hexagonalarchitecture.helpers.dto.ProductDto;
import com.know.hexagonalarchitecture.product.model.ProductBuilder;
import com.know.hexagonalarchitecture.usecase.product.FindOneProductUseCase;
import com.know.hexagonalarchitecture.usecase.product.ListProductsUseCase;
import com.know.hexagonalarchitecture.usecase.product.SaveProductUseCase;
import com.know.hexagonalarchitecture.usecase.product.UpdateProductUseCase;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController controller;
    @Mock
    private SaveProductUseCase saveProductUseCase;
    @Mock
    private ListProductsUseCase listProductsUseCase;
    @Mock
    private FindOneProductUseCase findOneProductUseCase;
    @Mock
    private UpdateProductUseCase updateProductUseCase;
    @Mock
    private DataFactory dataFactory;


    @Test
    public void shouldSaveProduct() throws BusinessException {
        //arrange
        ProductDto dto = new ProductDto();
        dto.setIdProduct(1L);
        dto.setIdUser(1L);
        dto.setName("XXX");
        dto.setPrice(200.0);

        when(saveProductUseCase.execute(any()))
                .thenReturn(new ProductBuilder().build());

        when(dataFactory.buildResponse(any(),any(),any()))
                .thenReturn(new ObjectDto());

        //act
        ResponseEntity<ObjectDto> response = controller.saveProduct(dto);
        //assert
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
    }


    @Test
    public void shouldShowAllProducts(){

        when(listProductsUseCase.execute())
                .thenReturn(Collections.singletonList(new ProductBuilder().build()));

        ResponseEntity<ObjectDto> response = controller.listAllProducts();

        assertEquals(HttpStatus.OK,response.getStatusCode());
    }


    @Test
    public void shouldOneProduct(){

        when(findOneProductUseCase.execute(anyLong()))
                .thenReturn( new ProductBuilder().build());

        ResponseEntity<ObjectDto> response = controller.OneProduct(1L);

        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    public void shouldUpdateOneProduct() throws BusinessException {

        ProductDto dto = new ProductDto();
        dto.setIdProduct(1L);
        dto.setIdUser(1L);
        dto.setName("XXX");
        dto.setPrice(200.0);

        when(updateProductUseCase.execute(any(),anyLong()))
                .thenReturn( new ProductBuilder().build());

        ResponseEntity<ObjectDto> response= controller.updateProduct(1L,dto);

    }

}