package com.paticasprototype.paticas.domain.usecase;

import com.paticasprototype.paticas.application.services.paticas.dtos.CreatePetRequest;
import com.paticasprototype.paticas.application.services.paticas.dtos.PetDTO;
import com.paticasprototype.paticas.application.services.paticas.dtos.UpdatePetRequest;
import com.paticasprototype.paticas.application.services.paticas.mapper.CreatePetMapper;
import com.paticasprototype.paticas.application.services.paticas.mapper.PetMapper;
import com.paticasprototype.paticas.application.services.shelters.dtos.ShelterDTO;
import com.paticasprototype.paticas.application.services.shelters.mapper.ShelterMapper;
import com.paticasprototype.paticas.domain.entities.Pet;
import com.paticasprototype.paticas.domain.entities.Shelter;
import com.paticasprototype.paticas.domain.repositories.PetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class PetUseCase {
    private final PetRepository petRepository;

    public PetUseCase(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(Long id) {
        return petRepository.findById(id);
    }

    public Pet createPet(CreatePetRequest petDto)throws IOException {
        Pet pet = new CreatePetMapper().toEntity(petDto);
        return petRepository.save(pet);
    }

    public Optional<Pet> updatePet(Long id, UpdatePetRequest petDetails) throws IOException {
        return petRepository.findById(id).map(existingPet -> {
            try {
                Pet updatedPet = new CreatePetMapper().updateEntity(existingPet, petDetails);
                return petRepository.save(updatedPet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public boolean deletePet(Long id) {
        return petRepository.findById(id).map(pet -> {
            petRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    public Page<PetDTO> getPaticasByShelterId(Long shelterId, Pageable pageable) {
        return petRepository.findByShelterId(shelterId, pageable).map(PetMapper::toDTO);
    }
}
