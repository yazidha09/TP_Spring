package com.recrutement.controller;

import com.recrutement.model.Profil;
import com.recrutement.service.ProfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profils")
public class ProfilController {

    private final ProfilService profilService;

    public ProfilController(ProfilService profilService) {
        this.profilService = profilService;
    }

    @PostMapping
    public ResponseEntity<Profil> createProfil(@RequestBody Profil profil) {
        return ResponseEntity.ok(profilService.saveProfil(profil));
    }

    @GetMapping
    public ResponseEntity<List<Profil>> getAllProfils() {
        return ResponseEntity.ok(profilService.getAllProfils());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profil> getProfilById(@PathVariable Long id) {
        return ResponseEntity.ok(profilService.getProfilById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profil> updateProfil(@PathVariable Long id, @RequestBody Profil profil) {
        return ResponseEntity.ok(profilService.updateProfil(id, profil));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfil(@PathVariable Long id) {
        profilService.deleteProfil(id);
        return ResponseEntity.noContent().build();
    }
}