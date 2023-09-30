package com.example.MyPlannerApp.repositories;

import com.example.MyPlannerApp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    List<Task> findAllByIdUserAndTaskDate(UUID idUser, LocalDate taskDate);

    List<Task> findAllByIdUserAndTaskDateAndType(UUID idUser, LocalDate taskDate, String type);

    void deleteAllByIdUser(UUID idUser);
}
