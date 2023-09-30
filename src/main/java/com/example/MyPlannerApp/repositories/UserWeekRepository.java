package com.example.MyPlannerApp.repositories;

import com.example.MyPlannerApp.models.UsersWeeks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserWeekRepository  extends JpaRepository<UsersWeeks, UUID> {
}
