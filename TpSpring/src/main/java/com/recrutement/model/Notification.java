package com.recrutement.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import com.recrutement.enums.TypeNotification;
import com.recrutement.enums.StatutNotification;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenu;

    private LocalDateTime dateEnvoi;

    @Enumerated(EnumType.STRING)
    private TypeNotification type;

    @Enumerated(EnumType.STRING)
    private StatutNotification statut;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Additional methods if needed
    public boolean isRead() {
        return this.statut == StatutNotification.LU;
    }

    public void markAsRead() {
        this.statut = StatutNotification.LU;
    }
}
