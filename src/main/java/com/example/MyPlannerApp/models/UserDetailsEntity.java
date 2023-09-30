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
@Table(name = "user_details", schema = "public", catalog = "dbname")
public class UserDetailsEntity {
    @Id
    @Column(name = "id_user_details", columnDefinition = "uuid")
    private UUID idUserDetails;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
}
