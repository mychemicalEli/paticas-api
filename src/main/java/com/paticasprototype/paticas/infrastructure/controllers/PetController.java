package com.paticasprototype.paticas.infrastructure.controllers;

import com.paticasprototype.paticas.application.services.paticas.dtos.CreatePetRequest;
import com.paticasprototype.paticas.application.services.paticas.dtos.GetPetByIdResponse;
import com.paticasprototype.paticas.application.services.paticas.dtos.PetDTO;
import com.paticasprototype.paticas.application.services.paticas.dtos.UpdatePetRequest;
import com.paticasprototype.paticas.application.services.paticas.mapper.PetMapper;
import com.paticasprototype.paticas.application.services.paticas.services.PetService;
import com.paticasprototype.paticas.domain.entities.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<PetDTO> getAllPets() {
        List<Pet> pets = petService.getAllPets();
        return pets.stream().map(PetMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPetByIdResponse> getPetById(@PathVariable Long id) {
        Optional<Pet> pet = petService.getPetById(id);
        return pet.map(p -> ResponseEntity.ok(PetMapper.toDetailDTO(p)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping( consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public PetDTO createPet( @ModelAttribute  CreatePetRequest pet) throws IOException {
        Pet createdPet = petService.createPet(pet);
        return PetMapper.toDTO(createdPet);
    }


    @PutMapping(value = "/{id}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<PetDTO> updatePet(@PathVariable Long id, @ModelAttribute UpdatePetRequest petDetails) throws IOException {
        Optional<Pet> updatedPet = petService.updatePet(id, petDetails);
        return updatedPet.map(p -> ResponseEntity.ok(PetMapper.toDTO(p))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        boolean isDeleted = petService.deletePet(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/shelter/{shelterId}")
    public ResponseEntity<Page<PetDTO>> getPaticasByShelterId(
            @PathVariable Long shelterId,
            Pageable pageable) {
        return ResponseEntity.ok(petService.getPaticasByShelterId(shelterId, pageable));
    }
}