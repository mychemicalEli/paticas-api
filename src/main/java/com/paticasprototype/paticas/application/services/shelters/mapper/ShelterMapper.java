package com.paticasprototype.paticas.application.services.shelters.mapper;

import com.paticasprototype.paticas.application.services.shelters.dtos.ShelterDTO;
import com.paticasprototype.paticas.domain.entities.Shelter;

public class ShelterMapper {

    // Método estático para convertir un objeto Shelter en un objeto ShelterDTO
    public static ShelterDTO toDTO(Shelter shelter) {
        ShelterDTO dto = new ShelterDTO(); // Se crea una nueva instancia de ShelterDTO
        dto.setId(shelter.getId()); // Se establece el ID del refugio en el DTO
        dto.setProfileImage(shelter.getProfileImage()); // Se establece la imagen de perfil del refugio en el DTO
        dto.setName(shelter.getName()); // Se establece el nombre del refugio en el DTO
        dto.setLocation(shelter.getLocation()); // Se establece la ubicación del refugio en el DTO
        dto.setDescription(shelter.getDescription()); // Se establece la descripción del refugio en el DTO
        return dto; // Se devuelve el DTO creado
    }

    // Método estático para convertir un objeto ShelterDTO en un objeto Shelter
    public static Shelter toEntity(ShelterDTO dto) {
        Shelter shelter = new Shelter(); // Se crea una nueva instancia de Shelter
        shelter.setId(dto.getId()); // Se establece el ID del refugio en el objeto Shelter
        shelter.setProfileImage(dto.getProfileImage()); // Se establece la imagen de perfil del refugio en el objeto Shelter
        shelter.setName(dto.getName()); // Se establece el nombre del refugio en el objeto Shelter
        shelter.setLocation(dto.getLocation()); // Se establece la ubicación del refugio en el objeto Shelter
        shelter.setDescription(dto.getDescription()); // Se establece la descripción del refugio en el objeto Shelter
        return shelter; // Se devuelve el objeto Shelter creado
    }
}
