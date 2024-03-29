package com.know.hexagonalarchitecture.jparepository.user;

import com.know.hexagonalarchitecture.jparepository.product.ProductData;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="USUARIO")
public class UserPersonData {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_USUARIO", nullable = false)
    private Long idUser;
    @Column(name="NOMBRE", nullable = false)
    private String name;
    @Column(name="APELLIDO", nullable = false)
    private String lastName;
    @Column(name="TIPO_DOCUMENTO", nullable = false)
    private String typeDocument;
    @Column(name="NUMERO_DOCUMENTO")
    private String numberDocument;
    @Column(name="DNI_USUARIO")
    private String dniUser;
    @OneToMany(mappedBy="users")
    private List<ProductData> products;

    public UserPersonData(){

    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getDniUser() {
        return dniUser;
    }

    public void setDniUser(String dniUser) {
        this.dniUser = dniUser;
    }

    public List<ProductData> getProducts() {
        return products;
    }

    public void setProducts(List<ProductData> products) {
        this.products = products;
    }
}
