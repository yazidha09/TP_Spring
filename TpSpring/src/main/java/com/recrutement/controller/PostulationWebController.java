package com.recrutement.controller;

import com.recrutement.model.Postulation;
import com.recrutement.service.PostulationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class PostulationWebController {
    private final PostulationService postulationService;

    public PostulationWebController(PostulationService postulationService) {
        this.postulationService = postulationService;
    }

    @GetMapping("/postulations")
    public String listPostulations(Model model) {
        model.addAttribute("postulations", postulationService.getAllPostulations());
        return "postulations";
    }

    @GetMapping("/postulations/create")
    public String showCreatePostulationForm(Model model) {
        model.addAttribute("postulation", new Postulation());
        return "create_postulation";
    }

    @PostMapping("/postulations/create")
    public String createPostulation(@ModelAttribute Postulation postulation) {
        postulation.setDatePostulation(LocalDateTime.now());
        postulationService.savePostulation(postulation);
        return "redirect:/postulations";
    }

    @GetMapping("/postulations/edit/{id}")
    public String showEditPostulationForm(@PathVariable Long id, Model model) {
        Postulation postulation = postulationService.getPostulationById(id);
        model.addAttribute("postulation", postulation);
        return "edit_postulation";
    }

    @PostMapping("/postulations/edit/{id}")
    public String updatePostulation(@PathVariable Long id, @ModelAttribute Postulation postulation) {
        postulationService.updatePostulation(id, postulation);
        return "redirect:/postulations";
    }

    @GetMapping("/postulations/delete/{id}")
    public String deletePostulation(@PathVariable Long id) {
        postulationService.deletePostulation(id);
        return "redirect:/postulations";
    }
}