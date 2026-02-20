package com.just_pay.transaction_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String senderId;

    private String receiverId;

    private LocalDateTime timeStamp;

    private String status;

    private Double amount;

    @PrePersist
    public void prePersist(){
        if(timeStamp==null){
            timeStamp= LocalDateTime.now();
        }
        if(status==null){
            status="pending";
        }
    }
}
