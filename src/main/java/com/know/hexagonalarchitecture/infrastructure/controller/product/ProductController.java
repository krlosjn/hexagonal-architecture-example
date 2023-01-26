package com.know.hexagonalarchitecture.infrastructure.controller.product;


import com.know.hexagonalarchitecture.application.product.usecase.DeleteProductUseCase;
import com.know.hexagonalarchitecture.application.product.usecase.ListProducts;
import com.know.hexagonalarchitecture.application.product.usecase.SaveProductUseCase;
import com.know.hexagonalarchitecture.application.product.usecase.UpdateProductUseCase;
import com.know.hexagonalarchitecture.domain.product.model.Product;
import com.know.hexagonalarchitecture.infrastructure.helpers.dto.DataFactory;
import com.know.hexagonalarchitecture.infrastructure.helpers.dto.ObjectDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;

@RestController
@RequestMapping(value="v1/productos")
public class ProductController {

    private final SaveProductUseCase saveProductUseCase;
    private final ListProducts listProducts;
    private final DeleteProductUseCase deleteProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DataFactory factory;



    public ProductController(SaveProductUseCase saveProductUseCase, DataFactory factory,ListProducts listProducts, DeleteProductUseCase deleteProductUseCase,UpdateProductUseCase updateProductUseCase){
        this.saveProductUseCase = saveProductUseCase;
        this.listProducts=listProducts;
        this.deleteProductUseCase=deleteProductUseCase;
        this.updateProductUseCase=updateProductUseCase;
        this.factory=factory;

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(this.factory
                .buildResponse("Productos",
                        Arrays.asList(this.saveProductUseCase.execute(product)),null ), HttpStatus.OK);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> listAllProducts(){
        return new ResponseEntity<>(this.factory
                .buildResponse("Listar Productos",Arrays.asList(this.listProducts.execute()),null),HttpStatus.OK);
    }


    @PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> updateProduct(@PathVariable(value="id") Long id,@RequestBody Product product){
        return new ResponseEntity<>(this.factory.buildResponse("update product ",
                Arrays.asList(this.updateProductUseCase.execute(product, id)),null),HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") Long id ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.deleteProductUseCase.execute(id));
    }

}
