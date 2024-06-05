package com.paticasprototype.paticas.domain.entities;

import jakarta.persistence.*;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Constructor, getters y setters

    public Roles() {
        // Constructor vacío requerido por JPA
    }

    public Roles(String name) {
        this.name = name;
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
}
