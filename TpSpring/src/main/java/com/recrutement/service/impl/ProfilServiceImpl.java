package com.recrutement.service.impl;

import com.recrutement.model.Profil;
import com.recrutement.repository.ProfilRepository;
import com.recrutement.service.ProfilService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilServiceImpl implements ProfilService {

    private final ProfilRepository profilRepository;

    public ProfilServiceImpl(ProfilRepository profilRepository) {
        this.profilRepository = profilRepository;
    }

    @Override
    public Profil saveProfil(Profil profil) {
        return profilRepository.save(profil);
    }

    @Override
    public List<Profil> getAllProfils() {
        return profilRepository.findAll();
    }

    @Override
    public Profil getProfilById(Long id) {
        return profilRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProfil(Long id) {
        profilRepository.deleteById(id);
    }

    @Override
    public Profil updateProfil(Long id, Profil profil) {
        Profil existing = profilRepository.findById(id).orElseThrow();
        existing.setCvPath(profil.getCvPath());
        existing.setCompetences(profil.getCompetences());
        existing.setExperiences(profil.getExperiences());
        existing.setUser(profil.getUser());
        return profilRepository.save(existing);
    }
}