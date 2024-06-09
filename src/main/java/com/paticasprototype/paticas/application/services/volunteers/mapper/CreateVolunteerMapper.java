package com.paticasprototype.paticas.application.services.volunteers.mapper;

import com.paticasprototype.paticas.application.helpers.FileSaver;
import com.paticasprototype.paticas.application.services.volunteers.dtos.CreateVolunteerRequest;
import com.paticasprototype.paticas.application.services.volunteers.dtos.UpdateVolunteerRequest;
import com.paticasprototype.paticas.domain.entities.Shelter;
import com.paticasprototype.paticas.domain.entities.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CreateVolunteerMapper {

    // Instancia de FileSaver para guardar archivos
    FileSaver fileSaver = new FileSaver();

    // Método para mapear un objeto CreateVolunteerRequest a una entidad Volunteer
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

    // Método para mapear un objeto UpdateVolunteerRequest a una entidad Volunteer
    public Volunteer toEntity(UpdateVolunteerRequest dto) throws IOException {
        // Crear una nueva instancia de Volunteer
        Volunteer volunteer = new Volunteer();

        // Verificar si hay una nueva imagen de perfil y guardar el archivo, luego obtener la URL
        if (dto.getProfileImage() != null && !dto.getProfileImage().isEmpty()) {
            volunteer.setProfileImage(fileSaver.saveFile(dto.getProfileImage()));
        }

        // Establecer la disponibilidad del voluntario
        volunteer.setAvailability(dto.getAvailability());

        // Establecer el correo electrónico del voluntario
        volunteer.setEmail(dto.getEmail());

        // Establecer el nombre completo del voluntario
        volunteer.setFullName(dto.getFullName());

        // Establecer el número de teléfono del voluntario
        volunteer.setPhone(dto.getPhone());

        // Crear una nueva instancia de Shelter y establecer su ID
        Shelter shelter = new Shelter();
        shelter.setId(dto.getShelterId());

        // Establecer el refugio asociado al voluntario
        volunteer.setShelter(shelter);

        return volunteer; // Devolver el voluntario mapeado
    }
}
