package com.just_pay.notification_service.service;

import com.just_pay.notification_service.model.Notification;

import java.util.List;

public interface NotificationService {
    Notification getById(Long id);

    List<Notification> getAllByUserId(Long userId);
}
