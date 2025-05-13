package com.recrutement.model;

import jakarta.persistence.*;
import lombok.Data;
import com.recrutement.enums.StatutEntretien ;
import java.time.LocalDateTime;
@Entity
@Data
public class Entretien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateHeure;
    private String lieu;
    private String notes;

    @Enumerated(EnumType.STRING)
    private StatutEntretien statut;

    @OneToOne
    private Postulation postulation;
}
