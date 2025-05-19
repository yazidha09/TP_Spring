package com.recrutement.controller;

import com.recrutement.model.Entretien;
import com.recrutement.service.EntretienService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class EntretienWebController {
    private final EntretienService entretienService;

    public EntretienWebController(EntretienService entretienService) {
        this.entretienService = entretienService;
    }

    @GetMapping("/entretiens")
    public String listEntretiens(Model model) {
        model.addAttribute("entretiens", entretienService.getAllEntretiens());
        return "entretiens";
    }

    @GetMapping("/entretiens/create")
    public String showCreateEntretienForm(Model model) {
        model.addAttribute("entretien", new Entretien());
        return "create_entretien";
    }

    @PostMapping("/entretiens/create")
    public String createEntretien(@ModelAttribute Entretien entretien) {
        entretien.setDateHeure(LocalDateTime.now());
        entretienService.saveEntretien(entretien);
        return "redirect:/entretiens";
    }
}