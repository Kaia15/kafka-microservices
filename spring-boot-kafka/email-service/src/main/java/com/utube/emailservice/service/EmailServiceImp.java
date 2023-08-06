package com.utube.emailservice.service;

import java.util.List;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.utube.emailservice.entity.Email;
import com.utube.emailservice.repository.EmailRepository;

@Service
public class EmailServiceImp implements EmailService {
    private EmailRepository emailRepository;
    private JavaMailSender javaMailSender;
    
    public EmailServiceImp(EmailRepository emailRepository, JavaMailSender javaMailSender) {
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
    }

    public List<Email> listAll() {
        return emailRepository.findAll();
    };
    public Email create(Email email) {
        return email;
    };
    public void saveOrUpdate(Email email) {
        emailRepository.save(email);
    };
    public void sendEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("no-reply@XXX.io");
        message.setTo(email.getRecipientEmail());
        message.setSubject(email.getSubject());
        message.setText(email.getBodyText());

        javaMailSender.send(message);
    }
}
