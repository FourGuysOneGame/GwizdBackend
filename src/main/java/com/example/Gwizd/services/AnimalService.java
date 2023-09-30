package com.example.Gwizd.services;

import com.example.Gwizd.models.Animal;
import com.example.Gwizd.repositories.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;

    public Animal getAnimal(String species, String description, String localization, Boolean dangerous) {
        Optional<Animal> animalBySpeciesAndLocalization = animalRepository.findAnimalBySpeciesAndLocalization(species, localization);
        if (animalBySpeciesAndLocalization.isPresent()) {
            return animalBySpeciesAndLocalization.get();
        } else {
            Animal animal = new Animal(species, description, localization, dangerous);
            animalRepository.save(animal);
            return animal;
        }
    }
}
