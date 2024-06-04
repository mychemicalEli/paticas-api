package com.paticasprototype.paticas;

import com.paticasprototype.paticas.domain.repositories.PetRepository;
import com.paticasprototype.paticas.domain.usecase.PetUseCase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public PetUseCase petUseCase(PetRepository petRepository) {
        return new PetUseCase(petRepository);
    }


}