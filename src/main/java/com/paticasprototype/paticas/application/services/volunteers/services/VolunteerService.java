package com.paticasprototype.paticas.application.services.volunteers.services;

import com.paticasprototype.paticas.application.services.volunteers.dtos.CreateVolunteerRequest;
import com.paticasprototype.paticas.application.services.volunteers.dtos.UpdateVolunteerRequest;
import com.paticasprototype.paticas.application.services.volunteers.dtos.VolunteerDTO;
import com.paticasprototype.paticas.domain.usecase.VolunteerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerUseCase volunteerUseCase;

    // Método para obtener todos los voluntarios
    public List<VolunteerDTO> getAllVolunteers() {
        return volunteerUseCase.getAllVolunteers();
    }

    // Método para obtener un voluntario por su ID
    public Optional<VolunteerDTO> getVolunteerById(Long id) {
        return volunteerUseCase.getVolunteerById(id);
    }

    // Método para crear un nuevo voluntario
    // Método para crear un nuevo voluntario
    public VolunteerDTO createVolunteer(CreateVolunteerRequest request) throws IOException {
        return volunteerUseCase.createVolunteer(request);
    }


    // Método para actualizar un voluntario existente
    public Optional<VolunteerDTO> updateVolunteer(Long id, UpdateVolunteerRequest volunteerDTO) {
        return volunteerUseCase.updateVolunteer(id, volunteerDTO);
    }

    // Método para eliminar un voluntario
    public boolean deleteVolunteer(Long id) {
        return volunteerUseCase.deleteVolunteer(id);
    }

    // Método para obtener voluntarios por el ID del refugio
    public Page<VolunteerDTO> getVolunteersByShelterId(Long shelterId, Pageable pageable) {
        return volunteerUseCase.getVolunteersByShelterId(shelterId,pageable);
    }
}
