package com.just_pay.notification_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    private int id;

    private String senderId;

    private String receiverId;

    private LocalDateTime timeStamp;

    private String status;

    private Double amount;

}
