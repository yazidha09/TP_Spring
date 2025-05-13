package com.recrutement.service;

import com.recrutement.model.Profil;
import java.util.List;

public interface ProfilService {
    Profil saveProfil(Profil profil);
    List<Profil> getAllProfils();
    Profil getProfilById(Long id);
    Profil updateProfil(Long id, Profil profil);
    void deleteProfil(Long id);
}