package com.know.hexagonalarchitecture.infrastructure.adapters.jparepository.product;


import javax.persistence.*;

@Entity
@Table(name="Producto")
public class ProductData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto",nullable = false)
    private Long id;

    @Column(name="nombre_producto", nullable = false)
    private String name;

    @Column(name="Precio")
    private double price;

    public ProductData(){

    }

    public void setId(Long id){
        this.id=id;
    }
    public Long getId(){
        return this.id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return this.price;
    }
}
