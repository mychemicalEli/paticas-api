package com.paticasprototype.paticas.application.services.volunteers.dtos;

import org.springframework.web.multipart.MultipartFile;

public class UpdateVolunteerRequest {
    private Long id; // ID del voluntario a actualizar
    private MultipartFile profileImage; // Nueva imagen de perfil del voluntario
    private String fullName; // Nuevo nombre completo del voluntario
    private String phone; // Nuevo número de teléfono del voluntario
    private String email; // Nuevo correo electrónico del voluntario
    private int availability; // Nueva disponibilidad del voluntario
    private Long shelterId; // Nuevo ID del refugio asociado al voluntario

    // Getters y Setters

    // Método para obtener el ID del voluntario a actualizar
    public Long getId() {
        return id;
    }

    // Método para establecer el ID del voluntario a actualizar
    public void setId(Long id) {
        this.id = id;
    }

    // Método para obtener la nueva imagen de perfil del voluntario
    public MultipartFile getProfileImage() {
        return profileImage;
    }

    // Método para establecer la nueva imagen de perfil del voluntario
    public void setProfileImage(MultipartFile profileImage) {
        this.profileImage = profileImage;
    }

    // Método para obtener el nuevo nombre completo del voluntario
    public String getFullName() {
        return fullName;
    }

    // Método para establecer el nuevo nombre completo del voluntario
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Método para obtener el nuevo número de teléfono del voluntario
    public String getPhone() {
        return phone;
    }

    // Método para establecer el nuevo número de teléfono del voluntario
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Método para obtener el nuevo correo electrónico del voluntario
    public String getEmail() {
        return email;
    }

    // Método para establecer el nuevo correo electrónico del voluntario
    public void setEmail(String email) {
        this.email = email;
    }

    // Método para obtener la nueva disponibilidad del voluntario
    public int getAvailability() {
        return availability;
    }

    // Método para establecer la nueva disponibilidad del voluntario
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    // Método para obtener el nuevo ID del refugio asociado al voluntario
    public Long getShelterId() {
        return shelterId;
    }

    // Método para establecer el nuevo ID del refugio asociado al voluntario
    public void setShelterId(Long shelterId) {
        this.shelterId = shelterId;
    }
}
