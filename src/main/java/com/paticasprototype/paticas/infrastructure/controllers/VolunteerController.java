package com.paticasprototype.paticas.infrastructure.controllers;

import com.paticasprototype.paticas.application.services.paticas.dtos.PetDTO;
import com.paticasprototype.paticas.application.services.volunteers.dtos.CreateVolunteerRequest;
import com.paticasprototype.paticas.application.services.volunteers.dtos.UpdateVolunteerRequest;
import com.paticasprototype.paticas.application.services.volunteers.dtos.VolunteerDTO;
import com.paticasprototype.paticas.application.services.volunteers.services.VolunteerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {

    // Servicio de voluntarios
    private final VolunteerService volunteerService;

    // Constructor que inyecta el servicio de voluntarios como dependencia
    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    // Endpoint para obtener todos los voluntarios
    @GetMapping
    public List<VolunteerDTO> getAllVolunteers() {
        return volunteerService.getAllVolunteers();
    }

    // Endpoint para obtener un voluntario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<VolunteerDTO> getVolunteerById(@PathVariable Long id) {
        Optional<VolunteerDTO> volunteer = volunteerService.getVolunteerById(id);
        return volunteer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un voluntario
    @PostMapping( consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public VolunteerDTO createVolunteer(@ModelAttribute CreateVolunteerRequest volunteerDTO) throws IOException {
        return volunteerService.createVolunteer(volunteerDTO);
    }

    // Endpoint para actualizar un voluntario por su ID
    @PutMapping(value = "/{id}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<VolunteerDTO> updateVolunteer(@PathVariable Long id, @ModelAttribute UpdateVolunteerRequest volunteerDTO) throws IOException {
        Optional<VolunteerDTO> updatedVolunteer = volunteerService.updateVolunteer(id, volunteerDTO);
        return updatedVolunteer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para eliminar un voluntario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVolunteer(@PathVariable Long id) {
        boolean isDeleted = volunteerService.deleteVolunteer(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    // Endpoint para obtener voluntarios por el ID de un refugio con paginación
    @GetMapping("/shelter/{shelterId}")
    public ResponseEntity<Page<VolunteerDTO>> getVolunteersByShelterId(
            @PathVariable Long shelterId,
            Pageable pageable) {
        return ResponseEntity.ok(volunteerService.getVolunteersByShelterId(shelterId, pageable));
    }
}
