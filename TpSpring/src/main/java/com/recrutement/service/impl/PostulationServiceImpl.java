package com.recrutement.service.impl;

import com.recrutement.model.Postulation;
import com.recrutement.repository.PostulationRepository;
import com.recrutement.service.PostulationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostulationServiceImpl implements PostulationService {

    private final PostulationRepository postulationRepository;

    public PostulationServiceImpl(PostulationRepository postulationRepository) {
        this.postulationRepository = postulationRepository;
    }

    @Override
    public Postulation savePostulation(Postulation postulation) {
        return postulationRepository.save(postulation);
    }

    @Override
    public List<Postulation> getAllPostulations() {
        return postulationRepository.findAll();
    }

    @Override
    public Postulation getPostulationById(Long id) {
        return postulationRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePostulation(Long id) {
        postulationRepository.deleteById(id);
    }

    @Override
    public Postulation updatePostulation(Long id, Postulation postulation) {
        Postulation existing = postulationRepository.findById(id).orElseThrow();
        existing.setDatePostulation(postulation.getDatePostulation());
        existing.setStatut(postulation.getStatut());
        existing.setCvSoumis(postulation.getCvSoumis());
        existing.setCandidat(postulation.getCandidat());
        existing.setOffre(postulation.getOffre());
        return postulationRepository.save(existing);
    }
}