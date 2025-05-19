package com.recrutement.controller;

import com.recrutement.model.Notification;
import com.recrutement.service.NotificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class NotificationWebController {
    private final NotificationService notificationService;

    public NotificationWebController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notifications")
    public String listNotifications(Model model) {
        model.addAttribute("notifications", notificationService.getAllNotifications());
        return "notifications";
    }

    @GetMapping("/notifications/create")
    public String showCreateNotificationForm(Model model) {
        model.addAttribute("notification", new Notification());
        return "create_notification";
    }

    @PostMapping("/notifications/create")
    public String createNotification(@ModelAttribute Notification notification) {
        notification.setDateEnvoi(LocalDateTime.now());
        notificationService.saveNotification(notification);
        return "redirect:/notifications";
    }
}