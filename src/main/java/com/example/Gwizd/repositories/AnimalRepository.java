package com.example.Gwizd.repositories;

import com.example.Gwizd.models.Animal;
import com.example.Gwizd.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, UUID> {
    @Query("SELECT a FROM Animal a WHERE a.species=?1")
    Optional<Animal> findBySpecies(String species);

    @Query("SELECT a FROM Animal a WHERE a.species=?1  AND a.localization=?2")
    Optional<Animal> findAnimalBySpeciesAndLocalization(String species, String localization);
}