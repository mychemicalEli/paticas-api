package com.paticasprototype.paticas.domain.repositories;

import com.paticasprototype.paticas.domain.entities.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {
}
