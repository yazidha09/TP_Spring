package com.recrutement.controller;

import com.recrutement.model.Entretien;
import com.recrutement.service.EntretienService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entretiens")
public class EntretienController {

    private final EntretienService entretienService;

    public EntretienController(EntretienService entretienService) {
        this.entretienService = entretienService;
    }

    @PostMapping
    public ResponseEntity<Entretien> createEntretien(@RequestBody Entretien entretien) {
        return ResponseEntity.ok(entretienService.saveEntretien(entretien));
    }

    @GetMapping
    public ResponseEntity<List<Entretien>> getAllEntretiens() {
        return ResponseEntity.ok(entretienService.getAllEntretiens());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entretien> getEntretienById(@PathVariable Long id) {
        return ResponseEntity.ok(entretienService.getEntretienById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entretien> updateEntretien(@PathVariable Long id, @RequestBody Entretien entretien) {
        return ResponseEntity.ok(entretienService.updateEntretien(id, entretien));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntretien(@PathVariable Long id) {
        entretienService.deleteEntretien(id);
        return ResponseEntity.noContent().build();
    }
}