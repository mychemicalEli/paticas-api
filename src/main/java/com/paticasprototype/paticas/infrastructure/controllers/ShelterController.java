package com.paticasprototype.paticas.infrastructure.controllers;

import com.paticasprototype.paticas.application.services.shelters.dtos.ShelterDTO;
import com.paticasprototype.paticas.application.services.shelters.services.ShelterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shelters")
public class ShelterController {

    // Servicio de refugios
    private final ShelterService shelterService;

    // Constructor que inyecta el servicio de refugios como dependencia
    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    // Endpoint para obtener todos los refugios
    @GetMapping
    public List<ShelterDTO> getAllShelters() {
        return shelterService.getAllShelters();
    }

    // Endpoint para obtener un refugio por su ID
    @GetMapping("/{id}")
    public ResponseEntity<ShelterDTO> getShelterById(@PathVariable Long id) {
        Optional<ShelterDTO> shelter = shelterService.getShelterById(id);
        return shelter.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un refugio
    @PostMapping
    public ShelterDTO createShelter(@RequestBody ShelterDTO shelterDTO) {
        return shelterService.createShelter(shelterDTO);
    }

    // Endpoint para actualizar un refugio por su ID
    @PutMapping("/{id}")
    public ResponseEntity<ShelterDTO> updateShelter(@PathVariable Long id, @RequestBody ShelterDTO shelterDTO) {
        Optional<ShelterDTO> updatedShelter = shelterService.updateShelter(id, shelterDTO);
        return updatedShelter.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para eliminar un refugio por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShelter(@PathVariable Long id) {
        boolean isDeleted = shelterService.deleteShelter(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
