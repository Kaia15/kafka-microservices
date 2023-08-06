package com.utube.emailservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "emails")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;
    private String senderEmail;
    private Long senderId;
    private String recipientEmail;
    private Long recipientId;
    private String subject;
    private String status;
    private String bodyText;

    public void setEmailId(Long id) {
        this.emailId = id;
    }

    public void setSenderEmail(String email) {
        this.senderEmail = email;
    }

    public void setRecipientEmail(String email) {
        this.recipientEmail = email;
    }

    public void setRecipientId(Long id) {
        this.recipientId = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBodyText(String text) {
        this.bodyText = text;
    } 

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getEmailId() {
        return this.emailId;
    }

    public String getSenderEmail() {
        return this.senderEmail;
    }

    public String getRecipientEmail() {
        return this.recipientEmail;
    }

    public Long getSenderId() {
        return this.senderId;
    }

    public Long getRecipientId() {
        return this.recipientId;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getBodyText() {
        return this.bodyText;
    }
}
