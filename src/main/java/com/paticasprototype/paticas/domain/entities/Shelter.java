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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Pet> getPaticas() {
        return pets;
    }

    public void setPaticas(List<Pet> pets) {
        this.pets = pets;
    }
}