package com.paticasprototype.paticas.application.services.shelters.services;

import com.paticasprototype.paticas.application.services.shelters.dtos.ShelterDTO;
import com.paticasprototype.paticas.domain.usecase.ShelterUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShelterService {

    @Autowired
    private ShelterUseCase shelterUseCase; // Inyección de dependencia del caso de uso de refugios

    // Método para obtener todos los refugios
    public List<ShelterDTO> getAllShelters() {
        return shelterUseCase.getAllShelters(); // Llama al método del caso de uso para obtener todos los refugios
    }

    // Método para obtener un refugio por su ID
    public Optional<ShelterDTO> getShelterById(Long id) {
        return shelterUseCase.getShelterById(id); // Llama al método del caso de uso para obtener un refugio por su ID
    }

    // Método para crear un nuevo refugio
    public ShelterDTO createShelter(ShelterDTO shelterDTO) {
        return shelterUseCase.createShelter(shelterDTO); // Llama al método del caso de uso para crear un nuevo refugio
    }

    // Método para actualizar un refugio existente
    public Optional<ShelterDTO> updateShelter(Long id, ShelterDTO shelterDTO) {
        return shelterUseCase.updateShelter(id, shelterDTO); // Llama al método del caso de uso para actualizar un refugio existente
    }

    // Método para eliminar un refugio por su ID
    public boolean deleteShelter(Long id) {
        return shelterUseCase.deleteShelter(id); // Llama al método del caso de uso para eliminar un refugio por su ID
    }
}
