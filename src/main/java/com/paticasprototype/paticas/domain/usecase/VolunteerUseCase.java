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

@Service
public class VolunteerUseCase {

    @Autowired
    private VolunteerRepository volunteerRepository;

    @Autowired
    private ShelterRepository shelterRepository;

    public List<VolunteerDTO> getAllVolunteers() {
        return volunteerRepository.findAll().stream()
                .map(VolunteerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<VolunteerDTO> getVolunteerById(Long id) {
        return volunteerRepository.findById(id).map(VolunteerMapper::toDTO);
    }

    public VolunteerDTO createVolunteer(CreateVolunteerRequest volunteerDTO) throws IOException {
        CreateVolunteerMapper volunteerMapper = new CreateVolunteerMapper();
        Volunteer volunteer = volunteerMapper.toEntity(volunteerDTO);
        Shelter shelter = shelterRepository.findById(volunteerDTO.getShelterId())
                .orElseThrow(() -> new RuntimeException("Shelter not found"));
        volunteer.setShelter(shelter);
        return VolunteerMapper.toDTO(volunteerRepository.save(volunteer));
    }

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
            Shelter shelter = shelterRepository.findById(volunteerDTO.getShelterId())
                    .orElseThrow(() -> new RuntimeException("Shelter not found"));
            volunteer.setShelter(shelter);
            return VolunteerMapper.toDTO(volunteerRepository.save(volunteer));
        });
    }

    public boolean deleteVolunteer(Long id) {
        if (volunteerRepository.existsById(id)) {
            volunteerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<VolunteerDTO> getVolunteersByShelterId(Long shelterId, Pageable pageable) {
        return volunteerRepository.findByShelterId(shelterId, pageable).map(VolunteerMapper::toDTO);
    }
}