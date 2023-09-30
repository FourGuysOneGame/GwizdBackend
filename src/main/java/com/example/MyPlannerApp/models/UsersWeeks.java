package com.example.MyPlannerApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_weeks", schema = "public", catalog = "dbname")
public class UsersWeeks {
    @Id
    @Column(name = "id_user_week", columnDefinition = "uuid")
    private UUID idUserWeek;
    @Basic
    @Column(name = "id_user", columnDefinition = "uuid")
    private UUID idUser;
    @Basic
    @Column(name = "id_week", columnDefinition = "uuid")
    private UUID idWeek;

    public UsersWeeks(UUID idUser, UUID idWeek) {
        this.idUserWeek = UUID.randomUUID();
        this.idUser = idUser;
        this.idWeek = idWeek;
    }

}
