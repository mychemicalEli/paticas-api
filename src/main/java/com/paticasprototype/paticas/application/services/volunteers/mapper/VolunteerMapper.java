package com.paticasprototype.paticas.application.services.volunteers.mapper;

import com.paticasprototype.paticas.application.helpers.FileSaver;
import com.paticasprototype.paticas.application.services.volunteers.dtos.VolunteerDTO;
import com.paticasprototype.paticas.domain.entities.Volunteer;

public class VolunteerMapper {

    // Método para mapear una entidad Volunteer a un DTO VolunteerDTO
    public static VolunteerDTO toDTO(Volunteer volunteer) {
        // Crear una nueva instancia de VolunteerDTO
        VolunteerDTO dto = new VolunteerDTO();

        // Establecer el ID del voluntario
        dto.setId(volunteer.getId());

        // Obtener la URL de la imagen de perfil del voluntario y establecerla en el DTO
        dto.setProfileImage(FileSaver.toUrl(volunteer.getProfileImage()));

        // Establecer el nombre completo del voluntario en el DTO
        dto.setFullName(volunteer.getFullName());

        // Establecer el número de teléfono del voluntario en el DTO
        dto.setPhone(volunteer.getPhone());

        // Establecer el correo electrónico del voluntario en el DTO
        dto.setEmail(volunteer.getEmail());

        // Establecer la disponibilidad del voluntario en el DTO
        dto.setAvailability(volunteer.getAvailability());

        // Obtener el ID del refugio asociado al voluntario y establecerlo en el DTO
        dto.setShelterId(volunteer.getShelter().getId());

        return dto; // Devolver el DTO VolunteerDTO mapeado
    }

    // Método para mapear un DTO VolunteerDTO a una entidad Volunteer
    public static Volunteer toEntity(VolunteerDTO dto) {
        // Crear una nueva instancia de Volunteer
        Volunteer volunteer = new Volunteer();

        // Establecer el ID del voluntario en la entidad
        volunteer.setId(dto.getId());

        // Establecer la imagen de perfil del voluntario en la entidad (se establecerá por separado para evitar problemas de carga diferida)
        volunteer.setProfileImage(dto.getProfileImage());

        // Establecer el nombre completo del voluntario en la entidad
        volunteer.setFullName(dto.getFullName());

        // Establecer el número de teléfono del voluntario en la entidad
        volunteer.setPhone(dto.getPhone());

        // Establecer el correo electrónico del voluntario en la entidad
        volunteer.setEmail(dto.getEmail());

        // Establecer la disponibilidad del voluntario en la entidad
        volunteer.setAvailability(dto.getAvailability());

        // El refugio se establecerá por separado para evitar problemas de carga diferida

        return volunteer; // Devolver la entidad Volunteer mapeada
    }
}
