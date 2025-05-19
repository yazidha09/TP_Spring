package com.recrutement.controller;

import com.recrutement.model.User;
import com.recrutement.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class UserWebController {
    private final UserService userService;

    public UserWebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/users/create")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User());
        return "create_user";
    }

    @PostMapping("/users/create")
    public String createUser(@ModelAttribute User user) {
        user.setDateInscription(LocalDateTime.now());
        userService.saveUser(user);
        return "redirect:/users";
    }
}
