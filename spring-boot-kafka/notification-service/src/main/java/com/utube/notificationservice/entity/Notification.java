package com.utube.notificationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;
    private String notificationMessage;
    private Long notificationRecipient;

    public void setNotificationMessage(String message) {
        this.notificationMessage = message;
    }

    public void setNotificationRecipient(Long id) {
        this.notificationRecipient = id;
    }

    public String getNotificatonMessage() {
        return this.notificationMessage;
    }
}
