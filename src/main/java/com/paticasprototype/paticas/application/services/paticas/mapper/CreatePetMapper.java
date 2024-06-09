package com.paticasprototype.paticas.application.services.paticas.mapper;

import com.paticasprototype.paticas.application.helpers.FileSaver;
import com.paticasprototype.paticas.application.services.paticas.dtos.CreatePetRequest;
import com.paticasprototype.paticas.application.services.paticas.dtos.UpdatePetRequest;
import com.paticasprototype.paticas.domain.entities.Pet;
import com.paticasprototype.paticas.domain.entities.Shelter;
import com.paticasprototype.paticas.infrastructure.config.ConfigConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class CreatePetMapper {
    FileSaver fileSaver = new FileSaver();

    public Pet toEntity(CreatePetRequest dto) throws IOException {
        Pet pet = new Pet();
        pet.setProfileImage(fileSaver.saveFile(dto.getProfileImage()));
        pet.setImageCarousel1(fileSaver.saveFile(dto.getImageCarousel1()));
        pet.setImageCarousel2(fileSaver.saveFile(dto.getImageCarousel2()));
        pet.setImageCarousel3(fileSaver.saveFile(dto.getImageCarousel3()));
        pet.setName(dto.getName());
        pet.setGender(dto.getGender());
        pet.setSize(dto.getSize());
        pet.setBirthDate(dto.getBirthDate());
        pet.setSpecies(dto.getSpecies());
        pet.setDescription(dto.getDescription());
        pet.setGoodWithKids(dto.isGoodWithKids());
        pet.setGoodWithDogs(dto.isGoodWithDogs());
        pet.setGoodWithCats(dto.isGoodWithCats());
        pet.setLiked(dto.isLiked());

        Shelter shelter = new Shelter();
        shelter.setId(dto.getShelterId());
        pet.setShelter(shelter);
        return pet;
    }


public Pet updateEntity(Pet pet, UpdatePetRequest dto) throws IOException {

        if (dto.getProfileImage() != null && !dto.getProfileImage().isEmpty()) {
            pet.setProfileImage(fileSaver.saveFile(dto.getProfileImage()));
        }
        if (dto.getImageCarousel1() != null && !dto.getImageCarousel1().isEmpty()) {
            pet.setImageCarousel1(fileSaver.saveFile(dto.getImageCarousel1()));
        }
        if (dto.getImageCarousel2() != null && !dto.getImageCarousel2().isEmpty()) {
            pet.setImageCarousel2(fileSaver.saveFile(dto.getImageCarousel2()));
        }
        if (dto.getImageCarousel3() != null && !dto.getImageCarousel3().isEmpty()) {
            pet.setImageCarousel3(fileSaver.saveFile(dto.getImageCarousel3()));
        }

        pet.setName(dto.getName());
        pet.setGender(dto.getGender());
        pet.setSize(dto.getSize());
        pet.setBirthDate(dto.getBirthDate());
        pet.setSpecies(dto.getSpecies());
        pet.setDescription(dto.getDescription());
        pet.setGoodWithKids(dto.isGoodWithKids());
        pet.setGoodWithDogs(dto.isGoodWithDogs());
        pet.setGoodWithCats(dto.isGoodWithCats());
        pet.setLiked(dto.isLiked());

        Shelter shelter = new Shelter();
        shelter.setId(dto.getShelterId());
        pet.setShelter(shelter);

        return pet;
    }
}