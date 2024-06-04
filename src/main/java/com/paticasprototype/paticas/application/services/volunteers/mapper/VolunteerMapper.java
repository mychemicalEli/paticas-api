package com.paticasprototype.paticas.application.services.volunteers.mapper;

import com.paticasprototype.paticas.application.helpers.FileSaver;
import com.paticasprototype.paticas.application.services.volunteers.dtos.VolunteerDTO;
import com.paticasprototype.paticas.domain.entities.Volunteer;

public class VolunteerMapper {

    public static VolunteerDTO toDTO(Volunteer volunteer) {
        VolunteerDTO dto = new VolunteerDTO();
        dto.setId(volunteer.getId());
        dto.setProfileImage(FileSaver.toUrl(volunteer.getProfileImage()));
        dto.setFullName(volunteer.getFullName());
        dto.setPhone(volunteer.getPhone());
        dto.setEmail(volunteer.getEmail());
        dto.setAvailability(volunteer.getAvailability());
        dto.setShelterId(volunteer.getShelter().getId());
        return dto;
    }

    public static Volunteer toEntity(VolunteerDTO dto) {
        Volunteer volunteer = new Volunteer();
        volunteer.setId(dto.getId());
        volunteer.setProfileImage(dto.getProfileImage());
        volunteer.setFullName(dto.getFullName());
        volunteer.setPhone(dto.getPhone());
        volunteer.setEmail(dto.getEmail());
        volunteer.setAvailability(dto.getAvailability());
        // Shelter will be set separately to avoid lazy loading issues
        return volunteer;
    }
}