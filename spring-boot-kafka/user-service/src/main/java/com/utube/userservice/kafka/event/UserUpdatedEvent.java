package com.utube.userservice.kafka.event;

public class UserUpdatedEvent {
    Long userId;
    String prevEmail;
    String currEmail;
    String prevPassword;
    String currPassword;
    String prevPhone;
    String currPhone;

    public void setUserId(Long id) {
        this.userId = id;
    }

    public void setPrevEmail(String mail) {
        this.prevEmail = mail;
    }

    public void setCurrEmail(String mail) {
        this.currEmail = mail;
    }

    public void setPrevPassword(String password) {
        this.prevPassword = password;
    }

    public void setCurrPassword(String password) {
        this.currPassword = password;
    }

    public void setPrevPhone(String phone) {
        this.prevPhone = phone;
    }

    public void setCurrPhone(String phone) {
        this.currPhone = phone;
    }

    public Long getUserId() {
        return this.userId;
    }

    public String getPrevEmail() {
        return this.prevEmail;
    }

    public String getCurrEmail() {
        return this.currEmail;
    }

    public String getPrevPassword() {
        return this.prevPassword;
    }

    public String getCurrPassword() {
        return this.currPassword;
    }
}
