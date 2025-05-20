package com.recrutement.controller;

import com.recrutement.model.Entretien;
import com.recrutement.service.EntretienService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/entretiens/edit/{id}")
    public String showEditEntretienForm(@PathVariable Long id, Model model) {
        Entretien entretien = entretienService.getEntretienById(id);
        model.addAttribute("entretien", entretien);
        return "edit_entretien";
    }

    @PostMapping("/entretiens/edit/{id}")
    public String updateEntretien(@PathVariable Long id, @ModelAttribute Entretien entretien) {
        entretienService.updateEntretien(id, entretien);
        return "redirect:/entretiens";
    }

    @GetMapping("/entretiens/delete/{id}")
    public String deleteEntretien(@PathVariable Long id) {
        entretienService.deleteEntretien(id);
        return "redirect:/entretiens";
    }

    @GetMapping("/entretiens/edit")
    public String redirectEditEntretienById(@RequestParam Long id) {
        return "redirect:/entretiens/edit/" + id;
    }

    @GetMapping("/entretiens/delete")
    public String redirectDeleteEntretienById(@RequestParam Long id) {
        return "redirect:/entretiens/delete/" + id;
    }
}