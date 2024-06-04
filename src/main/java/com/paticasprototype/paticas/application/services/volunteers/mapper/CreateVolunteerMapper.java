package com.paticasprototype.paticas.application.services.volunteers.mapper;

import com.paticasprototype.paticas.application.helpers.FileSaver;
import com.paticasprototype.paticas.application.services.paticas.dtos.CreatePetRequest;
import com.paticasprototype.paticas.application.services.volunteers.dtos.CreateVolunteerRequest;
import com.paticasprototype.paticas.application.services.volunteers.dtos.UpdateVolunteerRequest;
import com.paticasprototype.paticas.domain.entities.Pet;
import com.paticasprototype.paticas.domain.entities.Shelter;
import com.paticasprototype.paticas.domain.entities.Volunteer;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CreateVolunteerMapper {
    FileSaver fileSaver = new FileSaver();
    public Volunteer toEntity(CreateVolunteerRequest dto) throws IOException {
        Volunteer volunteer = new Volunteer();
        volunteer.setProfileImage(fileSaver.saveFile(dto.getProfileImage()));
        volunteer.setAvailability(dto.getAvailability());
        volunteer.setEmail(dto.getEmail());
        volunteer.setFullName(dto.getFullName());
        volunteer.setPhone(dto.getPhone());

        Shelter shelter = new Shelter();
        shelter.setId(dto.getShelterId());
        volunteer.setShelter(shelter);

        return volunteer;
    }

    public Volunteer toEntity(UpdateVolunteerRequest dto) throws IOException {
        Volunteer volunteer = new Volunteer();

        if (dto.getProfileImage() != null && !dto.getProfileImage().isEmpty()) {
            volunteer.setProfileImage(fileSaver.saveFile(dto.getProfileImage()));
        }

        volunteer.setAvailability(dto.getAvailability());
        volunteer.setEmail(dto.getEmail());
        volunteer.setFullName(dto.getFullName());
        volunteer.setPhone(dto.getPhone());

        Shelter shelter = new Shelter();
        shelter.setId(dto.getShelterId());
        volunteer.setShelter(shelter);

        return volunteer;
    }
}
