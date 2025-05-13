package com.recrutement.controller;

import com.recrutement.model.Postulation;
import com.recrutement.service.PostulationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postulations")
public class PostulationController {

    private final PostulationService postulationService;

    public PostulationController(PostulationService postulationService) {
        this.postulationService = postulationService;
    }

    @PostMapping
    public ResponseEntity<Postulation> createPostulation(@RequestBody Postulation postulation) {
        return ResponseEntity.ok(postulationService.savePostulation(postulation));
    }

    @GetMapping
    public ResponseEntity<List<Postulation>> getAllPostulations() {
        return ResponseEntity.ok(postulationService.getAllPostulations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postulation> getPostulationById(@PathVariable Long id) {
        return ResponseEntity.ok(postulationService.getPostulationById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Postulation> updatePostulation(@PathVariable Long id, @RequestBody Postulation postulation) {
        return ResponseEntity.ok(postulationService.updatePostulation(id, postulation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostulation(@PathVariable Long id) {
        postulationService.deletePostulation(id);
        return ResponseEntity.noContent().build();
    }
}