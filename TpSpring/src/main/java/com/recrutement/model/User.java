package com.recrutement.model;
import jakarta.persistence.*;
import lombok.Data;
import com.recrutement.enums.Role;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role; // Enum à créer

    private LocalDateTime dateInscription;

    private boolean actif;}