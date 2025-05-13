package com.recrutement.service;

import com.recrutement.model.Postulation;
import java.util.List;

public interface PostulationService {
    Postulation savePostulation(Postulation postulation);
    List<Postulation> getAllPostulations();
    Postulation getPostulationById(Long id);
    Postulation updatePostulation(Long id, Postulation postulation);
    void deletePostulation(Long id);
}