package com.example.MyPlannerApp.repositories;

import com.example.MyPlannerApp.models.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDetailsEntityRepository extends JpaRepository<UserDetailsEntity, UUID> {
}
