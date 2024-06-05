package com.paticasprototype.paticas.application.services.paticas.mapper;

import com.paticasprototype.paticas.application.helpers.FileSaver;
import com.paticasprototype.paticas.application.services.paticas.dtos.CreatePetRequest;
import com.paticasprototype.paticas.application.services.paticas.dtos.UpdatePetRequest;
import com.paticasprototype.paticas.domain.entities.Pet;
import com.paticasprototype.paticas.domain.entities.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Component
public class CreatePetMapper {
    // Se inyecta una instancia de FileSaver para manejar el guardado de archivos.
    @Autowired
    FileSaver fileSaver;

    // Método para mapear un DTO de creación de mascota a una entidad de mascota.
    public Pet toEntity(CreatePetRequest dto) throws IOException {
        Pet patica = new Pet();
        // Se guarda y se establece la URL de la imagen de perfil.
        patica.setProfileImage(fileSaver.saveFile(dto.getProfileImage()));
        // Se guarda y se establece la URL de la primera imagen del carrusel.
        patica.setImageCarousel1(fileSaver.saveFile(dto.getImageCarousel1()));
        // Se guarda y se establece la URL de la segunda imagen del carrusel.
        patica.setImageCarousel2(fileSaver.saveFile(dto.getImageCarousel2()));
        // Se guarda y se establece la URL de la tercera imagen del carrusel.
        patica.setImageCarousel3(fileSaver.saveFile(dto.getImageCarousel3()));
        // Se establecen los demás atributos de la mascota.
        patica.setName(dto.getName());
        patica.setLocation(dto.getLocation());
        patica.setGender(dto.getGender());
        patica.setSize(dto.getSize());
        patica.setBirthDate(dto.getBirthDate());
        patica.setSpecies(dto.getSpecies());
        patica.setDescription(dto.getDescription());
        patica.setGoodWithKids(dto.isGoodWithKids());
        patica.setGoodWithDogs(dto.isGoodWithDogs());
        patica.setGoodWithCats(dto.isGoodWithCats());
        // Se crea una instancia de Shelter y se establece su ID en la mascota.
        Shelter shelter = new Shelter();
        shelter.setId(dto.getShelterId());
        patica.setShelter(shelter);
        return patica;
    }

    // Método para mapear un DTO de actualización de mascota a una entidad de mascota ya existente.
    public Pet updateEntity(Pet pet, UpdatePetRequest dto) throws IOException {
        // Se actualiza la imagen de perfil si se proporciona en el DTO.
        if (dto.getProfileImage() != null && !dto.getProfileImage().isEmpty()) {
            pet.setProfileImage(fileSaver.saveFile(dto.getProfileImage()));
        }
        // Se actualiza la primera imagen del carrusel si se proporciona en el DTO.
        if (dto.getImageCarousel1() != null && !dto.getImageCarousel1().isEmpty()) {
            pet.setImageCarousel1(fileSaver.saveFile(dto.getImageCarousel1()));
        }
        // Se actualiza la segunda imagen del carrusel si se proporciona en el DTO.
        if (dto.getImageCarousel2() != null && !dto.getImageCarousel2().isEmpty()) {
            pet.setImageCarousel2(fileSaver.saveFile(dto.getImageCarousel2()));
        }
        // Se actualiza la tercera imagen del carrusel si se proporciona en el DTO.
        if (dto.getImageCarousel3() != null && !dto.getImageCarousel3().isEmpty()) {
            pet.setImageCarousel3(fileSaver.saveFile(dto.getImageCarousel3()));
        }
        // Se actualizan los demás atributos de la mascota.
        pet.setName(dto.getName());
        pet.setLocation(dto.getLocation());
        pet.setGender(dto.getGender());
        pet.setSize(dto.getSize());
        pet.setBirthDate(dto.getBirthDate());
        pet.setSpecies(dto.getSpecies());
        pet.setDescription(dto.getDescription());
        pet.setGoodWithKids(dto.isGoodWithKids());
        pet.setGoodWithDogs(dto.isGoodWithDogs());
        pet.setGoodWithCats(dto.isGoodWithCats());
        // Se crea una instancia de Shelter y se establece su ID en la mascota.
        Shelter shelter = new Shelter();
        shelter.setId(dto.getShelterId());
        pet.setShelter(shelter);
        return pet;
    }
}
