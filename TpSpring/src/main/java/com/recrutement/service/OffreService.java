package com.recrutement.service;

import com.recrutement.model.Offre;
import java.util.List;

public interface OffreService {
    Offre saveOffre(Offre offre);
    List<Offre> getAllOffres();
    Offre getOffreById(Long id);
    Offre updateOffre(Long id, Offre offre);
    void deleteOffre(Long id);
}