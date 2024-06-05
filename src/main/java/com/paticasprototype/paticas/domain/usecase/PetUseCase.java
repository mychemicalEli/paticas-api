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
    // Repositorio para interactuar con las entidades de mascotas
    private final PetRepository petRepository;

    // Constructor que inyecta el repositorio como dependencia
    public PetUseCase(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    // Método para obtener todas las mascotas
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    // Método para obtener una mascota por su ID
    public Optional<Pet> getPetById(Long id) {
        return petRepository.findById(id);
    }

    // Método para crear una nueva mascota
    public Pet createPet(CreatePetRequest petDto)throws IOException {
        // Mapea los datos del DTO de creación a una entidad de mascota
        Pet pet = new CreatePetMapper().toEntity(petDto);
        // Guarda la mascota en el repositorio
        return petRepository.save(pet);
    }

    // Método para actualizar una mascota existente
    public Optional<Pet> updatePet(Long id, UpdatePetRequest petDetails) throws IOException {
        // Busca la mascota existente por su ID y la actualiza con los detalles proporcionados
        return petRepository.findById(id).map(existingPet -> {
            try {
                // Utiliza un mapper para actualizar la entidad de mascota
                Pet updatedPet = new CreatePetMapper().updateEntity(existingPet, petDetails);
                // Guarda los cambios en el repositorio
                return petRepository.save(updatedPet);
            } catch (IOException e) {
                // Manejo de excepciones
                throw new RuntimeException(e);
            }
        });
    }

    // Método para eliminar una mascota por su ID
    public boolean deletePet(Long id) {
        // Busca la mascota por su ID y la elimina si existe
        return petRepository.findById(id).map(pet -> {
            petRepository.deleteById(id);
            return true;
        }).orElse(false); // Devuelve falso si la mascota no existe
    }

    // Método para obtener mascotas por el ID de un refugio con paginación
    public Page<PetDTO> getPaticasByShelterId(Long shelterId, Pageable pageable) {
        // Utiliza el repositorio para obtener una página de mascotas asociadas a un refugio específico
        return petRepository.findByShelterId(shelterId, pageable).map(PetMapper::toDTO);
    }
}
