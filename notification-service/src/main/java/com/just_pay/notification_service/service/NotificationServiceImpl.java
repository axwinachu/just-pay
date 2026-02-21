package com.just_pay.notification_service.service;

import com.just_pay.notification_service.model.Notification;
import com.just_pay.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService{
    private final NotificationRepository notificationRepository;

    @Override
    public Notification getById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Notification not found"));
    }

    @Override
    public List<Notification> getAllByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }
}
