package com.paticasprototype.paticas.domain.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String profileImage;
    private String name;
    private String location;
    private String description;

    @OneToMany(mappedBy = "shelter", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Pet> pets;

    @OneToMany(mappedBy = "shelter", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Volunteer> volunteers;

    // Getters and Setters

    // Métodos para el ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Métodos para la imagen de perfil
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    // Métodos para el nombre
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Métodos para la ubicación
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Métodos para la descripción
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Métodos para obtener y establecer las mascotas asociadas
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    // Métodos para obtener y establecer los voluntarios asociados
    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }
}
