package com.just_pay.notification_service.controller;

import com.just_pay.notification_service.facade.NotificationFacade;
import com.just_pay.notification_service.model.Notification;
import com.just_pay.notification_service.service.NotificationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notification")
public class NotificationController {
    private final NotificationFacade notificationFacade;
    @GetMapping("/all")
    public List<Notification> getAllNotificationByUserId(@RequestHeader("X-USER-id") Long userid){
        return notificationFacade.getAllNotificationByUserId(userid);
    }
    @GetMapping("/{id}")
    public Notification getNotificationById(@PathVariable Long id){
        return notificationFacade.getNotificationById(id);
    }
}
