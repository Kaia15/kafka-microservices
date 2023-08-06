package com.utube.emailservice.service;

import java.util.List;

import com.utube.emailservice.entity.Email;

public interface EmailService {
    public List<Email> listAll();
    public Email create(Email email);
    public void saveOrUpdate(Email email);
    public void sendEmail(Email email);
}
