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

@Service
public class ShelterUseCase {

    @Autowired
    private ShelterRepository shelterRepository;

    public List<ShelterDTO> getAllShelters() {
        return shelterRepository.findAll().stream()
                .map(ShelterMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ShelterDTO> getShelterById(Long id) {
        return shelterRepository.findById(id).map(ShelterMapper::toDTO);
    }

    public ShelterDTO createShelter(ShelterDTO shelterDTO) {
        Shelter shelter = ShelterMapper.toEntity(shelterDTO);
        return ShelterMapper.toDTO(shelterRepository.save(shelter));
    }

    public Optional<ShelterDTO> updateShelter(Long id, ShelterDTO shelterDTO) {
        return shelterRepository.findById(id).map(existingShelter -> {
            Shelter shelter = ShelterMapper.toEntity(shelterDTO);
            shelter.setId(existingShelter.getId());
            return ShelterMapper.toDTO(shelterRepository.save(shelter));
        });
    }

    public boolean deleteShelter(Long id) {
        if (shelterRepository.existsById(id)) {
            shelterRepository.deleteById(id);
            return true;
        }
        return false;
    }
}