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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
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

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<?> createPet(
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("size") int size,
            @RequestParam("birthDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date birthDate,
            @RequestParam("species") String species,
            @RequestParam("description") String description,
            @RequestParam("goodWithKids") boolean goodWithKids,
            @RequestParam("goodWithDogs") boolean goodWithDogs,
            @RequestParam("goodWithCats") boolean goodWithCats,
            @RequestParam("liked") boolean liked,
            @RequestParam("shelterId") Long shelterId,
            @RequestParam("profileImage") MultipartFile profileImage,
            @RequestParam("imageCarousel1") MultipartFile imageCarousel1,
            @RequestParam("imageCarousel2") MultipartFile imageCarousel2,
            @RequestParam("imageCarousel3") MultipartFile imageCarousel3) {
        try {
            CreatePetRequest request = new CreatePetRequest();
            request.setName(name);
            request.setGender(gender);
            request.setSize(size);
            request.setBirthDate(birthDate);
            request.setSpecies(species);
            request.setDescription(description);
            request.setGoodWithKids(goodWithKids);
            request.setGoodWithDogs(goodWithDogs);
            request.setGoodWithCats(goodWithCats);
            request.setLiked(liked);
            request.setShelterId(shelterId);
            request.setProfileImage(profileImage);
            request.setImageCarousel1(imageCarousel1);
            request.setImageCarousel2(imageCarousel2);
            request.setImageCarousel3(imageCarousel3);

            PetDTO createdPet = petService.createPet(request);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdPet);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the pet.");
        }
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