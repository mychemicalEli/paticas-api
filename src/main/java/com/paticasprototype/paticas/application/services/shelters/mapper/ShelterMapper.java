package com.paticasprototype.paticas.application.services.shelters.mapper;

import com.paticasprototype.paticas.application.services.shelters.dtos.ShelterDTO;
import com.paticasprototype.paticas.domain.entities.Shelter;

public class ShelterMapper {
    public static ShelterDTO toDTO(Shelter shelter) {
        ShelterDTO dto = new ShelterDTO();
        dto.setId(shelter.getId());
        dto.setProfileImage(shelter.getProfileImage());
        dto.setName(shelter.getName());
        dto.setLocation(shelter.getLocation());
        dto.setDescription(shelter.getDescription());
        return dto;
    }

    public static Shelter toEntity(ShelterDTO dto) {
        Shelter shelter = new Shelter();
        shelter.setId(dto.getId());
        shelter.setProfileImage(dto.getProfileImage());
        shelter.setName(dto.getName());
        shelter.setLocation(dto.getLocation());
        shelter.setDescription(dto.getDescription());
        return shelter;
    }
}
