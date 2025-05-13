package com.recrutement.model;

import jakarta.persistence.*;
import lombok.Data;
import com.recrutement.enums.StatutPostulation;

import java.time.LocalDateTime;

@Entity
@Data
public class Postulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime datePostulation;

    @Enumerated(EnumType.STRING)
    private StatutPostulation statut;

    private String cvSoumis;

    @ManyToOne
    private User candidat;

    @ManyToOne
    private Offre offre;
}

