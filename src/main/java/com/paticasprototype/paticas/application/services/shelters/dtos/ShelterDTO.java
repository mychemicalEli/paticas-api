package com.paticasprototype.paticas.application.services.shelters.dtos;

public class ShelterDTO {
    private Long id;            // Identificador único del refugio
    private String profileImage; // Ruta de la imagen de perfil del refugio
    private String name;        // Nombre del refugio
    private String location;    // Ubicación del refugio
    private String description; // Descripción del refugio

    // Getters y Setters para acceder y modificar los campos privados

    // Método para obtener el ID del refugio
    public Long getId() {
        return id;
    }

    // Método para establecer el ID del refugio
    public void setId(Long id) {
        this.id = id;
    }

    // Método para obtener la ruta de la imagen de perfil del refugio
    public String getProfileImage() {
        return profileImage;
    }

    // Método para establecer la ruta de la imagen de perfil del refugio
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    // Método para obtener el nombre del refugio
    public String getName() {
        return name;
    }

    // Método para establecer el nombre del refugio
    public void setName(String name) {
        this.name = name;
    }

    // Método para obtener la ubicación del refugio
    public String getLocation() {
        return location;
    }

    // Método para establecer la ubicación del refugio
    public void setLocation(String location) {
        this.location = location;
    }

    // Método para obtener la descripción del refugio
    public String getDescription() {
        return description;
    }

    // Método para establecer la descripción del refugio
    public void setDescription(String description) {
        this.description = description;
    }
}
