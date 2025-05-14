package com.recrutement.service;

import com.recrutement.model.Notification;
import java.util.List;

public interface NotificationService {
    Notification saveNotification(Notification notification);
    List<Notification> getAllNotifications();
    Notification getNotificationById(Long id);
    void deleteNotification(Long id);
    Object updateNotification(Long id, Notification notification);
}