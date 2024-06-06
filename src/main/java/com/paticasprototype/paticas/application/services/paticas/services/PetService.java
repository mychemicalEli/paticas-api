package com.paticasprototype.paticas.application.services.paticas.services;

import com.paticasprototype.paticas.application.services.paticas.dtos.CreatePetRequest;
import com.paticasprototype.paticas.application.services.paticas.dtos.PetDTO;
import com.paticasprototype.paticas.application.services.paticas.dtos.UpdatePetRequest;
import com.paticasprototype.paticas.domain.entities.Pet;
import com.paticasprototype.paticas.domain.usecase.PetUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetUseCase petUseCase;

    public PetService(PetUseCase petUseCase) {
        this.petUseCase = petUseCase;
    }

    public List<Pet> getAllPets() {
        return petUseCase.getAllPets();
    }

    public Optional<Pet> getPetById(Long id) {
        return petUseCase.getPetById(id);
    }

    public Pet createPet(CreatePetRequest pet) throws IOException {
        return petUseCase.createPet(pet);
    }

    public Optional<Pet> updatePet(Long id, UpdatePetRequest petDetails) throws IOException {
        return petUseCase.updatePet(id, petDetails);
    }

    public boolean deletePet(Long id) {
        return petUseCase.deletePet(id);
    }

    public Page<PetDTO> getPaticasByShelterId(Long shelterId, Pageable pageable) {
        return petUseCase.getPaticasByShelterId(shelterId,pageable);
    }
}