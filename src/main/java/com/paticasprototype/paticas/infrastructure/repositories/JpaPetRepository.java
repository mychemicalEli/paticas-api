package com.paticasprototype.paticas.infrastructure.repositories;

import com.paticasprototype.paticas.domain.entities.Pet;
import com.paticasprototype.paticas.domain.repositories.PetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPetRepository extends JpaRepository<Pet, Long>, PetRepository {
    Page<Pet> findByShelterId(Long shelterId, Pageable pageable);
}