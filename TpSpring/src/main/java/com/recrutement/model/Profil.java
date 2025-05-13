package com.recrutement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Profil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cvPath;
    private String competences;
    private String experiences;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
