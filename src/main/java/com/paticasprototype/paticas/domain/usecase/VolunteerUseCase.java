package com.paticasprototype.paticas.domain.usecase;

import com.paticasprototype.paticas.application.services.paticas.mapper.PetMapper;
import com.paticasprototype.paticas.application.services.volunteers.dtos.CreateVolunteerRequest;
import com.paticasprototype.paticas.application.services.volunteers.dtos.UpdateVolunteerRequest;
import com.paticasprototype.paticas.application.services.volunteers.dtos.VolunteerDTO;
import com.paticasprototype.paticas.application.services.volunteers.mapper.CreateVolunteerMapper;
import com.paticasprototype.paticas.application.services.volunteers.mapper.VolunteerMapper;
import com.paticasprototype.paticas.domain.entities.Shelter;
import com.paticasprototype.paticas.domain.entities.Volunteer;
import com.paticasprototype.paticas.domain.repositories.ShelterRepository;
import com.paticasprototype.paticas.domain.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Anotación que marca esta clase como un servicio de Spring
@Service
public class VolunteerUseCase {

    // Inyección de dependencia del repositorio VolunteerRepository
    @Autowired
    private VolunteerRepository volunteerRepository;

    // Inyección de dependencia del repositorio ShelterRepository
    @Autowired
    private ShelterRepository shelterRepository;

    // Método para obtener todos los voluntarios y mapearlos a DTOs
    public List<VolunteerDTO> getAllVolunteers() {
        return volunteerRepository.findAll().stream()
                .map(VolunteerMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Método para obtener un voluntario por su ID y mapearlo a un DTO
    public Optional<VolunteerDTO> getVolunteerById(Long id) {
        return volunteerRepository.findById(id).map(VolunteerMapper::toDTO);
    }

    // Método para crear un nuevo voluntario a partir de un DTO y mapearlo a un DTO
    public VolunteerDTO createVolunteer(CreateVolunteerRequest request) throws IOException {
        CreateVolunteerMapper volunteerMapper = new CreateVolunteerMapper();
        Volunteer volunteer = volunteerMapper.toEntity(request);
        Shelter shelter = shelterRepository.findById(request.getShelterId())
                .orElseThrow(() -> new RuntimeException("Shelter not found"));
        volunteer.setShelter(shelter);
        return VolunteerMapper.toDTO(volunteerRepository.save(volunteer));
    }

    // Método para actualizar un voluntario existente y mapearlo a un DTO
    public Optional<VolunteerDTO> updateVolunteer(Long id, UpdateVolunteerRequest volunteerDTO)  {
        return volunteerRepository.findById(id).map(existingVolunteer -> {
            CreateVolunteerMapper volunteerMapper = new CreateVolunteerMapper();
            Volunteer volunteer = null;
            try {
                volunteer = volunteerMapper.toEntity(volunteerDTO);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            volunteer.setId(existingVolunteer.getId());
            // Se busca el refugio al que el voluntario está asociado y se establece en el voluntario
            Shelter shelter = shelterRepository.findById(volunteerDTO.getShelterId())
                    .orElseThrow(() -> new RuntimeException("Shelter not found"));
            volunteer.setShelter(shelter);
            return VolunteerMapper.toDTO(volunteerRepository.save(volunteer));
        });
    }

    // Método para eliminar un voluntario por su ID
    public boolean deleteVolunteer(Long id) {
        if (volunteerRepository.existsById(id)) {
            volunteerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Método para obtener voluntarios por el ID de un refugio con paginación
    public Page<VolunteerDTO> getVolunteersByShelterId(Long shelterId, Pageable pageable) {
        return volunteerRepository.findByShelterId(shelterId, pageable).map(VolunteerMapper::toDTO);
    }
}
