package com.recrutement.service.impl;

import com.recrutement.model.Entretien;
import com.recrutement.repository.EntretienRepository;
import com.recrutement.service.EntretienService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntretienServiceImpl implements EntretienService {

    private final EntretienRepository entretienRepository;

    public EntretienServiceImpl(EntretienRepository entretienRepository) {
        this.entretienRepository = entretienRepository;
    }

    @Override
    public Entretien saveEntretien(Entretien entretien) {
        return entretienRepository.save(entretien);
    }

    @Override
    public List<Entretien> getAllEntretiens() {
        return entretienRepository.findAll();
    }

    @Override
    public Entretien getEntretienById(Long id) {
        return entretienRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEntretien(Long id) {
        entretienRepository.deleteById(id);
    }

    @Override
    public Entretien updateEntretien(Long id, Entretien entretien) {
        Entretien existing = entretienRepository.findById(id).orElseThrow();
        existing.setDateHeure(entretien.getDateHeure());
        existing.setLieu(entretien.getLieu());
        existing.setNotes(entretien.getNotes());
        existing.setStatut(entretien.getStatut());
        existing.setPostulation(entretien.getPostulation());
        return entretienRepository.save(existing);
    }
}