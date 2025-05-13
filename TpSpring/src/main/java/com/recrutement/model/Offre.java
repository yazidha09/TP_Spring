package com.recrutement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import com.recrutement.enums.StatutOffre;
@Entity
@Data
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private String lieu;
    private LocalDateTime dateCreation;
    private LocalDateTime dateCloture;

    @Enumerated(EnumType.STRING)
    private StatutOffre statut;

    @ManyToOne
    @JoinColumn(name = "recruteur_id")
    private User recruteur;
}