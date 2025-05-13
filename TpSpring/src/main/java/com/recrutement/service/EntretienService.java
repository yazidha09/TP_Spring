package com.recrutement.service;

import com.recrutement.model.Entretien;
import java.util.List;

public interface EntretienService {
    Entretien saveEntretien(Entretien entretien);
    List<Entretien> getAllEntretiens();
    Entretien getEntretienById(Long id);
    Entretien updateEntretien(Long id, Entretien entretien);
    void deleteEntretien(Long id);
}