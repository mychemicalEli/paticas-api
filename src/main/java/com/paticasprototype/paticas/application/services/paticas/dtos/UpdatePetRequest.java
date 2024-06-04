package com.paticasprototype.paticas.application.services.paticas.dtos;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class UpdatePetRequest {
    private Long id;
    private MultipartFile profileImage;
    private MultipartFile imageCarousel1;
    private MultipartFile imageCarousel2;
    private MultipartFile imageCarousel3;
    private String name;
    private String location;
    private String gender;
    private int size;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String species;
    private String description;
    private boolean goodWithKids;
    private boolean goodWithDogs;
    private boolean goodWithCats;
    private Long shelterId;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(MultipartFile profileImage) {
        this.profileImage = profileImage;
    }

    public MultipartFile getImageCarousel1() {
        return imageCarousel1;
    }

    public void setImageCarousel1(MultipartFile imageCarousel1) {
        this.imageCarousel1 = imageCarousel1;
    }

    public MultipartFile getImageCarousel2() {
        return imageCarousel2;
    }

    public void setImageCarousel2(MultipartFile imageCarousel2) {
        this.imageCarousel2 = imageCarousel2;
    }

    public MultipartFile getImageCarousel3() {
        return imageCarousel3;
    }

    public void setImageCarousel3(MultipartFile imageCarousel3) {
        this.imageCarousel3 = imageCarousel3;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isGoodWithKids() {
        return goodWithKids;
    }

    public void setGoodWithKids(boolean goodWithKids) {
        this.goodWithKids = goodWithKids;
    }

    public boolean isGoodWithDogs() {
        return goodWithDogs;
    }

    public void setGoodWithDogs(boolean goodWithDogs) {
        this.goodWithDogs = goodWithDogs;
    }

    public boolean isGoodWithCats() {
        return goodWithCats;
    }

    public void setGoodWithCats(boolean goodWithCats) {
        this.goodWithCats = goodWithCats;
    }

    public Long getShelterId() {
        return shelterId;
    }

    public void setShelterId(Long shelterId) {
        this.shelterId = shelterId;
    }
}