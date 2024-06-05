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

    // Constructor que recibe una instancia de PetUseCase.
    public PetService(PetUseCase petUseCase) {
        this.petUseCase = petUseCase;
    }

    // Método para obtener todas las mascotas.
    public List<Pet> getAllPets() {
        return petUseCase.getAllPets();
    }

    // Método para obtener una mascota por su ID.
    public Optional<Pet> getPetById(Long id) {
        return petUseCase.getPetById(id);
    }

    // Método para crear una mascota a partir de los datos de CreatePetRequest.
    public Pet createPet(CreatePetRequest pet) throws IOException {
        return petUseCase.createPet(pet);
    }

    // Método para actualizar una mascota existente a partir de los detalles de UpdatePetRequest.
    public Optional<Pet> updatePet(Long id, UpdatePetRequest petDetails) throws IOException {
        return petUseCase.updatePet(id, petDetails);
    }

    // Método para eliminar una mascota por su ID.
    public boolean deletePet(Long id) {
        return petUseCase.deletePet(id);
    }

    // Método para obtener una página de mascotas por el ID del refugio.
    public Page<PetDTO> getPaticasByShelterId(Long shelterId, Pageable pageable) {
        return petUseCase.getPaticasByShelterId(shelterId, pageable);
    }
}
