package com.know.hexagonalarchitecture.jparepository.product;


import com.know.hexagonalarchitecture.jparepository.user.UserPersonData;

import javax.persistence.*;

@Entity
@Table(name="PRODUCTO")
public class ProductData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_PRODUCTO",nullable = false)
    private Long idProduct;

    @Column(name="NOMBRE_PRODUCTO", nullable = false)
    private String name;

    @Column(name="PRECIO")
    private double price;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private UserPersonData users;

    public ProductData(){

    }

    public void setIdProduct(Long idProduct){
        this.idProduct = idProduct;
    }
    public Long getIdProduct(){
        return this.idProduct;
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


    public UserPersonData getUsers() {
        return users;
    }

    public void setUsers(UserPersonData users) {
        this.users = users;
    }
}
