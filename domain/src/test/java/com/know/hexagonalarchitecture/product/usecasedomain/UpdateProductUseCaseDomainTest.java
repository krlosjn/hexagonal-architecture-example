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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UpdateProductUseCaseDomainTest extends TestCase {

        @InjectMocks
        private UpdateProductUseCaseDomain update;

        @Mock
        private ProductRepository repository;


        @Test
        public void shouldUpdateProduct() throws BusinessException {

                Product product = new ProductTestDataBuilder().build();

                when(repository.productExist(anyLong()))
                        .thenReturn(true);
                when(repository.updateProduct(any(),anyLong()))
                        .thenReturn(product);

                assertNotNull(update.updateProduct(product,1L));

        }

}