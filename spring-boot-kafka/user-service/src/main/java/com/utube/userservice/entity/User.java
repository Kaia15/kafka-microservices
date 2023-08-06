package com.utube.userservice.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
// import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userCountry;
    private String userPhone;
    private ArrayList<Long> notifications;
    private ArrayList<Long> subscribers;
    private ArrayList<Long> subscribees;
    private ArrayList<Long> emailThreads;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {
        this.subscribers = new ArrayList<Long>();
        this.notifications = new ArrayList<Long>();
        this.emailThreads = new ArrayList<Long>();
        this.subscribees = new ArrayList<Long>();
    }
    //     this.subscribeChannels.add(new Long(0));
    //     this.notifications.add(new Long(0));
    // }

    public void setUserName(String name) {
        this.userName = name;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }

    public void setUserPassword(String password) {
        this.userPassword = password;
    }

    public void setUserCountry(String country) {
        this.userCountry = country;
    }

    public void setUserPhone(String phone) {
        this.userPhone = phone;
    }

    public void setNotifications(Long item) {
        this.notifications.add(0, item);
    }

    public void setSubscribers(Long item) {
        this.subscribers.add(0, item);
    }

    public void setSubscribees(Long item) {
        this.subscribees.add(0, item);
    }
    
    public void setEmailThreads(Long item) {
        this.emailThreads.add(0, item);
    }

    public Long getUserId() {
        return this.userId;
    }
    
    public String getUserName() {
        return this.userName;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public String getUserCountry() {
        return this.userCountry;
    }

    public String getUserPhone() {
        return this.userPhone;
    }

    public ArrayList<Long> getNotifications() {
        return this.notifications;
    }

    public ArrayList<Long> getSubscribers() {
        return this.subscribers;
    }

    public ArrayList<Long> getEmailThreads() {
        return this.emailThreads;
    }

    public ArrayList<Long> getSubscribees() {
        return this.subscribees;
    }
}
