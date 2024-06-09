package com.paticasprototype.paticas.application.services.paticas.dtos;

import com.paticasprototype.paticas.application.services.shelters.dtos.ShelterDTO;

import java.util.Date;

public class GetPetByIdResponse {
    private Long id;
    private String profileImage;
    private String imageCarousel1;
    private String imageCarousel2;
    private String imageCarousel3;
    private String name;

    private String gender;
    private int size;
    private Date birthDate;
    private String species;
    private String description;
    private boolean goodWithKids;
    private boolean goodWithDogs;
    private boolean goodWithCats;
    private boolean liked;
    private ShelterDTO shelter;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public ShelterDTO getShelter() {
        return shelter;
    }

    public void setShelter(ShelterDTO shelter) {
        this.shelter = shelter;
    }
}