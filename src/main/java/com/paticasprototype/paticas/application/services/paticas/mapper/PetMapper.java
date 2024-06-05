package com.paticasprototype.paticas.application.services.paticas.mapper;

import com.paticasprototype.paticas.application.helpers.FileSaver;
import com.paticasprototype.paticas.application.services.paticas.dtos.CreatePetRequest;
import com.paticasprototype.paticas.application.services.paticas.dtos.GetPetByIdResponse;
import com.paticasprototype.paticas.application.services.paticas.dtos.PetDTO;
import com.paticasprototype.paticas.application.services.shelters.dtos.ShelterDTO;
import com.paticasprototype.paticas.application.services.shelters.mapper.ShelterMapper;
import com.paticasprototype.paticas.domain.entities.Pet;
import com.paticasprototype.paticas.domain.entities.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    // Método estático para mapear una entidad Pet a un DTO PetDTO.
    public static PetDTO toDTO(Pet pet) {
        PetDTO dto = new PetDTO();
        // Se establecen los atributos del DTO con los valores de la entidad Pet.
        dto.setId(pet.getId());
        dto.setProfileImage(FileSaver.toUrl(pet.getProfileImage()));
        dto.setImageCarousel1(FileSaver.toUrl(pet.getImageCarousel1()));
        dto.setImageCarousel2(FileSaver.toUrl(pet.getImageCarousel2()));
        dto.setImageCarousel3(FileSaver.toUrl(pet.getImageCarousel3()));
        dto.setName(pet.getName());
        dto.setLocation(pet.getLocation());
        dto.setGender(pet.getGender());
        dto.setSize(pet.getSize());
        dto.setBirthDate(pet.getBirthDate());
        dto.setSpecies(pet.getSpecies());
        dto.setDescription(pet.getDescription());
        dto.setGoodWithKids(pet.isGoodWithKids());
        dto.setGoodWithDogs(pet.isGoodWithDogs());
        dto.setGoodWithCats(pet.isGoodWithCats());
        dto.setShelterId(pet.getShelter().getId());
        return dto;
    }

    // Método para mapear un DTO PetDTO a una entidad Pet.
    public Pet toEntity(PetDTO dto) {
        Pet patica = new Pet();
        patica.setId(dto.getId());
        patica.setProfileImage(dto.getProfileImage());
        patica.setImageCarousel1(dto.getImageCarousel1());
        patica.setImageCarousel2(dto.getImageCarousel2());
        patica.setImageCarousel3(dto.getImageCarousel3());
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

    // Método estático para mapear una entidad Pet a un DTO detallado GetPetByIdResponse.
    public static GetPetByIdResponse toDetailDTO(Pet pet) {
        GetPetByIdResponse dto = new GetPetByIdResponse();
        // Se establecen los atributos del DTO con los valores de la entidad Pet.
        dto.setId(pet.getId());
        dto.setProfileImage(FileSaver.toUrl(pet.getProfileImage()));
        dto.setImageCarousel1(FileSaver.toUrl(pet.getImageCarousel1()));
        dto.setImageCarousel2(FileSaver.toUrl(pet.getImageCarousel2()));
        dto.setImageCarousel3(FileSaver.toUrl(pet.getImageCarousel3()));
        dto.setName(pet.getName());
        dto.setLocation(pet.getLocation());
        dto.setGender(pet.getGender());
        dto.setSize(pet.getSize());
        dto.setBirthDate(pet.getBirthDate());
        dto.setSpecies(pet.getSpecies());
        dto.setDescription(pet.getDescription());
        dto.setGoodWithKids(pet.isGoodWithKids());
        dto.setGoodWithDogs(pet.isGoodWithDogs());
        dto.setGoodWithCats(pet.isGoodWithCats());
        // Se mapea el objeto Shelter de la entidad Pet a un DTO ShelterDTO.
        dto.setShelter(ShelterMapper.toDTO(pet.getShelter()));
        return dto;
    }
}
