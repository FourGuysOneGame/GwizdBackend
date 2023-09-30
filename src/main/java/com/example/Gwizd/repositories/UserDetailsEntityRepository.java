package com.example.Gwizd.repositories;

import com.example.Gwizd.models.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDetailsEntityRepository extends JpaRepository<UserDetailsEntity, UUID> {
}
