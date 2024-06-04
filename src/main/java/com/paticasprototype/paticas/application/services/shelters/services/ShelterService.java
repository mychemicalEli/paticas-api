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
    private ShelterUseCase shelterUseCase;

    public List<ShelterDTO> getAllShelters() {
        return shelterUseCase.getAllShelters();
    }

    public Optional<ShelterDTO> getShelterById(Long id) {
        return shelterUseCase.getShelterById(id);
    }

    public ShelterDTO createShelter(ShelterDTO shelterDTO) {
        return shelterUseCase.createShelter(shelterDTO);
    }

    public Optional<ShelterDTO> updateShelter(Long id, ShelterDTO shelterDTO) {
        return shelterUseCase.updateShelter(id, shelterDTO);
    }

    public boolean deleteShelter(Long id) {
        return shelterUseCase.deleteShelter(id);
    }
}