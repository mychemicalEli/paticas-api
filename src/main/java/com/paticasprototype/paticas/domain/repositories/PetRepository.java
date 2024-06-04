package com.paticasprototype.paticas.domain.repositories;

import com.paticasprototype.paticas.domain.entities.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PetRepository {
    List<Pet> findAll();
    Optional<Pet> findById(Long id);
    Pet save(Pet pet);
    void deleteById(Long id);
    Page<Pet> findByShelterId(Long shelterId, Pageable pageable);
}