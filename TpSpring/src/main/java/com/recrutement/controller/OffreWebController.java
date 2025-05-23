package com.recrutement.controller;

import com.recrutement.model.Offre;
import com.recrutement.service.OffreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class OffreWebController {
    private final OffreService offreService;

    public OffreWebController(OffreService offreService) {
        this.offreService = offreService;
    }

    @GetMapping("/offres")
    public String listOffres(Model model) {
        model.addAttribute("offres", offreService.getAllOffres());
        return "offres";
    }

    @GetMapping("/offres/create")
    public String showCreateOffreForm(Model model) {
        model.addAttribute("offre", new Offre());
        return "create_offre";
    }

    @PostMapping("/offres/create")
    public String createOffre(@ModelAttribute Offre offre) {
        offre.setDateCreation(LocalDateTime.now());
        offreService.saveOffre(offre);
        return "redirect:/offres";
    }

    @GetMapping("/offres/edit/{id}")
    public String showEditOffreForm(@PathVariable Long id, Model model) {
        Offre offre = offreService.getOffreById(id);
        model.addAttribute("offre", offre);
        return "edit_offre";
    }

    @PostMapping("/offres/edit/{id}")
    public String updateOffre(@PathVariable Long id, @ModelAttribute Offre offre) {
        offreService.updateOffre(id, offre);
        return "redirect:/offres";
    }

    @GetMapping("/offres/delete/{id}")
    public String deleteOffre(@PathVariable Long id) {
        offreService.deleteOffre(id);
        return "redirect:/offres";
    }
}