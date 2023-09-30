package com.example.MyPlannerApp.controllers;

import com.example.MyPlannerApp.models.Task;
import com.example.MyPlannerApp.models.Week;
import com.example.MyPlannerApp.services.TaskService;
import com.example.MyPlannerApp.services.UserService;
import com.example.MyPlannerApp.services.WeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;
    private final WeekService weekService;

    @GetMapping("/date")
    public List<Task> getTasks(@RequestParam LocalDate date, Authentication authentication) {
        UUID userId = userService.getUserByEmail(authentication.getName()).getIdUser();
        return taskService.getTasksByDate(userId, date);
    }

    @GetMapping("/date/type")
    public List<Task> getTasks(@RequestParam LocalDate date, @RequestParam String type, Authentication authentication) {
        UUID userId = userService.getUserByEmail(authentication.getName()).getIdUser();
        return taskService.getTasksByDateAndType(userId, date, type);
    }

    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody Task task, Authentication authentication) {
        task.setIdUser(userService.getUserByEmail(authentication.getName()).getIdUser());

        UUID weekId;
        try {
            weekId = weekService.getWeek(task.getTaskDate().with(DayOfWeek.MONDAY),
                    task.getTaskDate().with(DayOfWeek.SUNDAY)).getIdWeek();
        } catch (IllegalStateException exception) {
            weekService.addWeek(new Week(task.getTaskDate().with(DayOfWeek.MONDAY),
                    task.getTaskDate().with(DayOfWeek.SUNDAY)));
            weekId = weekService.getWeek(task.getTaskDate().with(DayOfWeek.MONDAY),
                    task.getTaskDate().with(DayOfWeek.SUNDAY)).getIdWeek();
        }
        task.setIdWeek(weekId);
        taskService.addTask(task);
        return ResponseEntity.ok("");
    }

    @PutMapping(path = "{IdTask}")
    public void updateTask(
            @PathVariable("IdTask") UUID taskId,
            @RequestBody boolean done) {
        taskService.updateTask(taskId, done);
    }
}
