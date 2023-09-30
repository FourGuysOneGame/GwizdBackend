package com.example.MyPlannerApp.repositories;

import com.example.MyPlannerApp.models.Week;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WeekRepository extends JpaRepository<Week, UUID> {
    @Query("SELECT w FROM Week w WHERE w.startDate=?1 AND w.endDate=?2")
    Optional<Week> findWeeksByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);
}
