package com.know.hexagonalarchitecture.controller.product;


import com.know.hexagonalarchitecture.helpers.dto.DataFactory;
import com.know.hexagonalarchitecture.helpers.dto.ObjectDto;
import com.know.hexagonalarchitecture.helpers.dto.ProductDto;
import com.know.hexagonalarchitecture.product.model.Product;
import com.know.hexagonalarchitecture.usecase.product.DeleteProductUseCase;
import com.know.hexagonalarchitecture.usecase.product.ListProductsUseCase;
import com.know.hexagonalarchitecture.usecase.product.SaveProductUseCase;
import com.know.hexagonalarchitecture.usecase.product.UpdateProductUseCase;
import com.know.hexagonalarchitecture.utils.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

import static com.know.hexagonalarchitecture.helpers.dto.DtoFactory.createProduct;

@RestController
@RequestMapping(value="v1/productos")
public class ProductController {

    private final SaveProductUseCase saveProductUseCase;
    private final ListProductsUseCase listProducts;
    private final DeleteProductUseCase deleteProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DataFactory factory;



    public ProductController(SaveProductUseCase saveProductUseCase, DataFactory factory, ListProductsUseCase listProducts, DeleteProductUseCase deleteProductUseCase, UpdateProductUseCase updateProductUseCase){
        this.saveProductUseCase = saveProductUseCase;
        this.listProducts=listProducts;
        this.deleteProductUseCase=deleteProductUseCase;
        this.updateProductUseCase=updateProductUseCase;
        this.factory=factory;

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> saveProduct(@RequestBody ProductDto product) throws BusinessException {
        return new ResponseEntity<>(this.factory
                .buildResponse("Productos",
                        Collections.singletonList(this.saveProductUseCase.execute(createProduct(product))),null ), HttpStatus.OK);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> listAllProducts(){
        return new ResponseEntity<>(this.factory
                .buildResponse("Listar Productos", Collections.singletonList(this.listProducts.execute()),null),HttpStatus.OK);
    }


    @PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> updateProduct(@PathVariable(value="id") Long id,@RequestBody Product product) throws BusinessException {
        return new ResponseEntity<>(this.factory.buildResponse("update product ",
                Collections.singletonList(this.updateProductUseCase.execute(product, id)),null),HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") Long id ) throws BusinessException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.deleteProductUseCase.execute(id));
    }

}
