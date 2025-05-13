package com.recrutement.service.impl;

import com.recrutement.model.Offre;
import com.recrutement.repository.OffreRepository;
import com.recrutement.service.OffreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreServiceImpl implements OffreService {

    private final OffreRepository offreRepository;

    public OffreServiceImpl(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    @Override
    public Offre saveOffre(Offre offre) {
        return offreRepository.save(offre);
    }

    @Override
    public List<Offre> getAllOffres() {
        return offreRepository.findAll();
    }

    @Override
    public Offre getOffreById(Long id) {
        return offreRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOffre(Long id) {
        offreRepository.deleteById(id);
    }

    @Override
    public Offre updateOffre(Long id, Offre offre) {
        Offre existing = offreRepository.findById(id).orElseThrow();
        existing.setTitre(offre.getTitre());
        existing.setDescription(offre.getDescription());
        existing.setLieu(offre.getLieu());
        existing.setDateCreation(offre.getDateCreation());
        existing.setDateCloture(offre.getDateCloture());
        existing.setStatut(offre.getStatut());
        existing.setRecruteur(offre.getRecruteur());
        return offreRepository.save(existing);
    }
}