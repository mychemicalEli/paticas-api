package com.paticasprototype.paticas.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private String location;
    private String CIF;
    private String profileImage;
    private String backgroundImage;
    private String passwordHash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId", referencedColumnName = "id")
    private Roles role;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_likes_pets",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    @JsonIgnore
    private Set<Pet> pets;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_likes_shelters",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "shelter_id")
    )
    @JsonIgnore
    private Set<Shelter> shelters;

    // Constructor vacío requerido por JPA
    public Users() {
    }

    // Constructor con todas las propiedades
    public Users(String fullName, String email, String phone, String location, String CIF, String profileImage, String backgroundImage, String passwordHash, Roles role, Set<Pet> pets, Set<Shelter> shelters) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.CIF = CIF;
        this.profileImage = profileImage;
        this.backgroundImage = backgroundImage;
        this.passwordHash = passwordHash;
        this.role = role;
        this.pets = pets;
        this.shelters = shelters;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Set<Shelter> getShelters() {
        return shelters;
    }

    public void setShelters(Set<Shelter> shelters) {
        this.shelters = shelters;
    }
}
