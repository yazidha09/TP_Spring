package com.recrutement.controller;

import com.recrutement.model.Profil;
import com.recrutement.service.ProfilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
}