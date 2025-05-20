package com.recrutement.controller;

import com.recrutement.model.Profil;
import com.recrutement.service.ProfilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfilWebController {
    private final ProfilService profilService;

    public ProfilWebController(ProfilService profilService) {
        this.profilService = profilService;
    }

    @GetMapping("/profils")
    public String listProfils(Model model) {
        model.addAttribute("profils", profilService.getAllProfils());
        return "profils";
    }

    @GetMapping("/profils/create")
    public String showCreateProfilForm(Model model) {
        model.addAttribute("profil", new Profil());
        return "create_profil";
    }

    @PostMapping("/profils/create")
    public String createProfil(@ModelAttribute Profil profil) {
        profilService.saveProfil(profil);
        return "redirect:/profils";
    }

    @GetMapping("/profils/edit/{id}")
    public String showEditProfilForm(@PathVariable Long id, Model model) {
        Profil profil = profilService.getProfilById(id);
        model.addAttribute("profil", profil);
        return "edit_profil";
    }

    @PostMapping("/profils/edit/{id}")
    public String updateProfil(@PathVariable Long id, @ModelAttribute Profil profil) {
        profilService.updateProfil(id, profil);
        return "redirect:/profils";
    }

    @GetMapping("/profils/delete/{id}")
    public String deleteProfil(@PathVariable Long id) {
        profilService.deleteProfil(id);
        return "redirect:/profils";
    }
}