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
@Table(name = "animals", schema = "public", catalog = "dbname")
public class Animal {
    @Id
    @Column(name = "id_animal", columnDefinition = "uuid")
    private UUID idAnimal;
    @Basic
    @Column(name = "species")
    private String species;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "localization")
    private String localization;
    @Basic
    @Column(name = "dangerous")
    private Boolean dangerous;
    @Basic
    @Column(name = "reports_amount")
    private Integer reportsAmount;

    public Animal(String species, String description, String localization, Boolean dangerous) {
        this.idAnimal = UUID.randomUUID();
        this.species = species;
        this.description = description;
        this.localization = localization;
        this.dangerous = dangerous;
        this.reportsAmount = 1;
    }

    public UUID getIdAnimal() {
        return idAnimal;
    }

    public String getSpecies() {
        return species;
    }

    public String getDescription() {
        return description;
    }

    public String getLocalization() {
        return localization;
    }

    public Boolean getDangerous() {
        return dangerous;
    }

    public Integer getReportsAmount() {
        return reportsAmount;
    }
}
