package com.paticasprototype.paticas.infrastructure.controllers;

import com.paticasprototype.paticas.application.services.volunteers.dtos.CreateVolunteerRequest;
import com.paticasprototype.paticas.application.services.volunteers.dtos.UpdateVolunteerRequest;
import com.paticasprototype.paticas.application.services.volunteers.dtos.VolunteerDTO;
import com.paticasprototype.paticas.application.services.volunteers.services.VolunteerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<?> createVolunteer(
            @RequestParam("fullName") String fullName,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("availability") int availability,
            @RequestParam("profileImage") MultipartFile profileImage,
            @RequestParam("shelterId") Long shelterId) {
        try {
            // Utiliza el shelterId recibido del cliente, que debería ser siempre 10
            CreateVolunteerRequest request = new CreateVolunteerRequest();
            request.setFullName(fullName);
            request.setEmail(email);
            request.setPhone(phone);
            request.setAvailability(availability);
            request.setShelterId(shelterId);
            request.setProfileImage(profileImage);

            VolunteerDTO createdVolunteer = volunteerService.createVolunteer(request);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdVolunteer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the volunteer.");
        }
    }



    // Endpoint para actualizar un voluntario por su ID
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<VolunteerDTO> updateVolunteer(
            @PathVariable Long id,
            @RequestParam("fullName") String fullName,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("availability") int availability,
            @RequestParam("shelterId") Long shelterId,
            @RequestParam(value = "profileImage", required = false) MultipartFile profileImage) {
        try {
            UpdateVolunteerRequest request = new UpdateVolunteerRequest();
            request.setId(id);
            request.setFullName(fullName);
            request.setEmail(email);
            request.setPhone(phone);
            request.setAvailability(availability);
            request.setShelterId(shelterId);
            request.setProfileImage(profileImage);

            Optional<VolunteerDTO> updatedVolunteer = volunteerService.updateVolunteer(id, request);
            return updatedVolunteer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Opcionalmente, puedes cambiar null por un objeto VolunteerDTO vacío si lo prefieres
        }

    }



    // Endpoint para eliminar un voluntario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVolunteer(@PathVariable Long id) {
        boolean isDeleted = volunteerService.deleteVolunteer(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    // Endpoint para obtener voluntarios por el ID de un refugio con paginación

}
