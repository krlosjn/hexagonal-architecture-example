package com.know.hexagonalarchitecture.infrastructure.adapters.jparepository.user;


import javax.persistence.*;

@Entity
@Table(name="Usuario")
public class UserPersonData {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_usuario", nullable = false)
    private Long id;

    @Column(name="nombre", nullable = false)
    private String name;

    @Column(name="Apellido", nullable = false)
    private String lastName;

    @Column(name="Identificación", nullable = false)
    private String dniUser;

    public UserPersonData(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDniUser() {
        return dniUser;
    }

    public void setDniUser(String dniUser) {
        this.dniUser = dniUser;
    }
}
