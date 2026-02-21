package com.just_pay.notification_service.facade;

import com.just_pay.notification_service.model.Notification;
import com.just_pay.notification_service.service.NotificationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NotificationFacade {
    private final NotificationServiceImpl notificationService;
    public List<Notification> getAllNotificationByUserId(Long userid) {
        return notificationService.getAllByUserId(userid);
    }

    public Notification getNotificationById(Long id) {
        return notificationService.getById(id);
    }
}
