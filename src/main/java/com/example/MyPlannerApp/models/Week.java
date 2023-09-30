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
@Table(name = "weeks", schema = "public", catalog = "dbname")
public class Week {
    @Id
    @Column(name = "id_week", columnDefinition = "uuid")
    private UUID idWeek;
    @Basic
    @Column(name = "start_date")
    private LocalDate startDate;
    @Basic
    @Column(name = "end_date")
    private LocalDate endDate;

    public Week(LocalDate startDate, LocalDate endDate) {
        this.idWeek = UUID.randomUUID();
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
