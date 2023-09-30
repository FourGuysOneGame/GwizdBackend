package com.example.MyPlannerApp.services;

import com.example.MyPlannerApp.models.Task;
import com.example.MyPlannerApp.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getTasksByDate(UUID userId, LocalDate date) {
        return taskRepository.findAllByIdUserAndTaskDate(userId, date);
    }

    public List<Task> getTasksByDateAndType(UUID userId, LocalDate date, String type) {
        return taskRepository.findAllByIdUserAndTaskDateAndType(userId, date, type);
    }

    public void addTask(Task task) {
        task.setIdTask(UUID.randomUUID());
        taskRepository.save(task);
    }

    @Transactional
    public void updateTask(UUID taskId, boolean done) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new IllegalStateException("task with id: " + taskId + " does not exist")
        );
        task.setDone(done);
    }

    public void deleteTasksByUserId(UUID userId) {
        taskRepository.deleteAllByIdUser(userId);
    }
}
