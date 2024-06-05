package com.paticasprototype.paticas.domain.usecase;

import com.paticasprototype.paticas.application.services.shelters.dtos.ShelterDTO;
import com.paticasprototype.paticas.application.services.shelters.mapper.ShelterMapper;
import com.paticasprototype.paticas.domain.entities.Shelter;
import com.paticasprototype.paticas.domain.repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Anotación que marca esta clase como un servicio de Spring
@Service
public class ShelterUseCase {

    // Inyección de dependencia del repositorio ShelterRepository
    @Autowired
    private ShelterRepository shelterRepository;

    // Método para obtener todos los refugios y mapearlos a DTOs
    public List<ShelterDTO> getAllShelters() {
        return shelterRepository.findAll().stream()
                .map(ShelterMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Método para obtener un refugio por su ID y mapearlo a un DTO
    public Optional<ShelterDTO> getShelterById(Long id) {
        return shelterRepository.findById(id).map(ShelterMapper::toDTO);
    }

    // Método para crear un nuevo refugio a partir de un DTO y mapearlo a un DTO
    public ShelterDTO createShelter(ShelterDTO shelterDTO) {
        Shelter shelter = ShelterMapper.toEntity(shelterDTO);
        return ShelterMapper.toDTO(shelterRepository.save(shelter));
    }

    // Método para actualizar un refugio existente y mapearlo a un DTO
    public Optional<ShelterDTO> updateShelter(Long id, ShelterDTO shelterDTO) {
        return shelterRepository.findById(id).map(existingShelter -> {
            Shelter shelter = ShelterMapper.toEntity(shelterDTO);
            shelter.setId(existingShelter.getId());
            return ShelterMapper.toDTO(shelterRepository.save(shelter));
        });
    }

    // Método para eliminar un refugio por su ID
    public boolean deleteShelter(Long id) {
        if (shelterRepository.existsById(id)) { // Verifica si el refugio existe
            shelterRepository.deleteById(id); // Elimina el refugio
            return true; // Retorna verdadero si se eliminó correctamente
        }
        return false; // Retorna falso si el refugio no existe
    }
}
