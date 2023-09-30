package com.example.Gwizd.models;
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
@Table(name = "reports", schema = "public", catalog = "dbname")
public class Report {
    @Id
    @Column(name = "id_report", columnDefinition = "uuid")
    private UUID idReport;
    @Basic
    @Column(name = "lost")
    private Boolean lost;
    @Basic
    @Column(name = "longitude")
    private Double longitude;
    @Basic
    @Column(name = "latitude")
    private Double latitude;
    @Basic
    @Column(columnDefinition = "oidvector")
    private String photoOidVector;
    @Basic
    @Column(name = "id_user", columnDefinition = "uuid")
    private UUID idUser;
    @Basic
    @Column(name = "id_animal", columnDefinition = "uuid")
    private UUID idAnimal;

    public Report(Boolean lost, Double longitude, Double latitude, String photoOidVector) {
        this.idReport =  UUID.randomUUID();
        this.lost = lost;
        this.longitude = longitude;
        this.latitude = latitude;
        this.photoOidVector = photoOidVector;
    }
}