package com.utube.userservice.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userCountry;
    private String userPhone;
    private ArrayList<Long> notifications;
    private ArrayList<Long> subscribers;
    private ArrayList<Long> emailThreads;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // public User() {
    //     this.subscribeChannels = new ArrayList<Long>();
    //     this.notifications = new ArrayList<Long>();
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

    public void setEmailThreads(ArrayList<Long> threads) {
        this.emailThreads = threads;
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
}
