package com.example.MyPlannerApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks", schema = "public", catalog = "dbname")
public class Task {
    @Id
    @Column(name = "id_task", columnDefinition = "uuid")
    private UUID idTask;
    @Basic
    @Column(name = "id_user", columnDefinition = "uuid")
    private UUID idUser;
    @Basic
    @Column(name = "id_week", columnDefinition = "uuid")
    private UUID idWeek;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "task_date")
    private LocalDate taskDate;
    @Basic
    @Column(name = "done")
    private boolean done;

    public Task(UUID idUser, UUID idWeek, String name, String type, LocalDate taskDate, boolean done) {
        this.idTask = UUID.randomUUID();
        this.idUser = idUser;
        this.idWeek = idWeek;
        this.name = name;
        this.type = type;
        this.taskDate = taskDate;
        this.done = done;
    }
}
