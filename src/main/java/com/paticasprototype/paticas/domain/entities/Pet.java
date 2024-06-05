package com.paticasprototype.paticas.domain.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String profileImage;
    private String imageCarousel1;
    private String imageCarousel2;
    private String imageCarousel3;
    private String name;
    private String location;
    private String gender;
    private int size;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String species;
    private String description;
    private boolean goodWithKids;
    private boolean goodWithDogs;
    private boolean goodWithCats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

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

    // Métodos para el carrusel de imágenes
    public String getImageCarousel1() {
        return imageCarousel1;
    }

    public void setImageCarousel1(String imageCarousel1) {
        this.imageCarousel1 = imageCarousel1;
    }

    public String getImageCarousel2() {
        return imageCarousel2;
    }

    public void setImageCarousel2(String imageCarousel2) {
        this.imageCarousel2 = imageCarousel2;
    }

    public String getImageCarousel3() {
        return imageCarousel3;
    }

    public void setImageCarousel3(String imageCarousel3) {
        this.imageCarousel3 = imageCarousel3;
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

    // Métodos para el género
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Métodos para el tamaño
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // Métodos para la fecha de nacimiento
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    // Métodos para la especie
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    // Métodos para la descripción
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Métodos para saber si es bueno con niños
    public boolean isGoodWithKids() {
        return goodWithKids;
    }

    public void setGoodWithKids(boolean goodWithKids) {
        this.goodWithKids = goodWithKids;
    }

    // Métodos para saber si es bueno con perros
    public boolean isGoodWithDogs() {
        return goodWithDogs;
    }

    public void setGoodWithDogs(boolean goodWithDogs) {
        this.goodWithDogs = goodWithDogs;
    }

    // Métodos para saber si es bueno con gatos
    public boolean isGoodWithCats() {
        return goodWithCats;
    }

    public void setGoodWithCats(boolean goodWithCats) {
        this.goodWithCats = goodWithCats;
    }

    // Métodos para obtener y establecer el refugio asociado
    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }
}
