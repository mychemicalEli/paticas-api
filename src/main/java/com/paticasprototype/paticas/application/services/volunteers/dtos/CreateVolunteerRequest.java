package com.paticasprototype.paticas.application.services.volunteers.dtos;

import org.springframework.web.multipart.MultipartFile;

public class CreateVolunteerRequest {
    private MultipartFile profileImage; // Imagen de perfil del voluntario
    private String fullName; // Nombre completo del voluntario
    private String phone; // Número de teléfono del voluntario
    private String email; // Correo electrónico del voluntario
    private int availability; // Disponibilidad del voluntario (por ejemplo, horas por semana)
    private Long shelterId; // ID del refugio al que está asociado el voluntario

    // Getters y Setters

    // Método para obtener la imagen de perfil del voluntario
    public MultipartFile getProfileImage() {
        return profileImage;
    }

    // Método para establecer la imagen de perfil del voluntario
    public void setProfileImage(MultipartFile profileImage) {
        this.profileImage = profileImage;
    }

    // Método para obtener el nombre completo del voluntario
    public String getFullName() {
        return fullName;
    }

    // Método para establecer el nombre completo del voluntario
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Método para obtener el número de teléfono del voluntario
    public String getPhone() {
        return phone;
    }

    // Método para establecer el número de teléfono del voluntario
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Método para obtener el correo electrónico del voluntario
    public String getEmail() {
        return email;
    }

    // Método para establecer el correo electrónico del voluntario
    public void setEmail(String email) {
        this.email = email;
    }

    // Método para obtener la disponibilidad del voluntario
    public int getAvailability() {
        return availability;
    }

    // Método para establecer la disponibilidad del voluntario
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    // Método para obtener el ID del refugio asociado al voluntario
    public Long getShelterId() {
        return shelterId;
    }

    // Método para establecer el ID del refugio asociado al voluntario
    public void setShelterId(Long shelterId) {
        this.shelterId = shelterId;
    }
}
