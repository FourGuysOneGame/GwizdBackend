package com.example.Gwizd.config;

import com.example.Gwizd.models.*;
import com.example.Gwizd.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Configuration
public class DatabaseConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            UserDetailsEntityRepository userDetailsEntityRepository,
            UserRepository userRepository,
            AnimalRepository animalRepository) {
        return args -> {
            UUID userDetails1Id = UUID.randomUUID();
            UUID userDetails2Id = UUID.randomUUID();
            UUID user1Id = UUID.randomUUID();
            UUID user2Id = UUID.randomUUID();
            List<UserDetailsEntity> userDetailsEntities = new ArrayList<>();
            userDetailsEntities.add(new UserDetailsEntity(
                    userDetails1Id,
                    "John",
                    "Snow"
            ));
            userDetailsEntities.add(new UserDetailsEntity(
                    userDetails2Id,
                    "Kuba",
                    "Cudak"
            ));
            List<User> usersEntities = new ArrayList<>();
            usersEntities.add(new User(
                    user1Id,
                    "jsnow@wp.pl",
                    "$2a$10$bhiGBBGBax8Y2Z/Psp86Ue4cVKULgmbYkegPKrm/l/109bwOk/nW2",
                    userDetails1Id
            ));
            usersEntities.add(new User(
                    user2Id,
                    "kubcud@op.pl",
                    "$2a$10$bhiGBBGBax8Y2Z/Psp86Ue4cVKULgmbYkegPKrm/l/109bwOk/nW2",
                    userDetails2Id
            ));

            List<Animal> animalsEntities = new ArrayList<>();
            animalsEntities.add(new Animal(
                    "Cat",
                    "Black",
                    "Here",
                    true
            ));

            userDetailsEntityRepository.saveAll(userDetailsEntities);
            userRepository.saveAll(usersEntities);
            animalRepository.saveAll(animalsEntities);
        };
    }
}
