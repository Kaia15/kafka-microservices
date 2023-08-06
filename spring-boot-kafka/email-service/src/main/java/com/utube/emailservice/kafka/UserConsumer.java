package com.utube.emailservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.utube.userservice.kafka.event.UserCreatedEvent;
import com.utube.userservice.kafka.event.UserUpdatedEvent;
import com.utube.emailservice.service.EmailServiceImp;
import com.utube.emailservice.entity.Email;
import com.utube.emailservice.repository.EmailRepository;

@Service
public class UserConsumer {
    private static final Logger logger = LoggerFactory.getLogger(UserConsumer.class);
    private EmailServiceImp emailSrvc;
    private EmailRepository emailRepository;

    @Autowired
    public UserConsumer(EmailServiceImp emailService, EmailRepository emailRepository) {
        this.emailSrvc = emailService;
        this.emailRepository = emailRepository;
    }

    @KafkaListener(topics = "${spring.kafka.user-create-topic.name}", 
                    groupId = "${spring.kafka.consumer.group-id}")
    public void consumeUserCreatedEvent(UserCreatedEvent event) {
        logger.info(String.format("User event => %s", event.toString()));
        Email email_info = new Email(null, null, null, null, null, null, null, null);
        email_info.setRecipientEmail(event.getUserEmail());
        email_info.setRecipientId(event.getUserId());
        email_info.setSenderEmail("no-reply@xxxx.io");
        email_info.setSubject("Thank you for subscribing XXX");
        email_info.setBodyText("Welcome to XXX community!");
        emailSrvc.saveOrUpdate(email_info);
        
        emailSrvc.sendEmail(email_info);
        logger.info("Email sent successfully...");
    }

    @KafkaListener(topics = "${spring.kafka.user-update-topic.name}", 
                    groupId = "${spring.kafka.consumer.group-id}")
    public void consumeUserUpdatedEvent(UserUpdatedEvent event) {
        String currPassword = event.getCurrPassword();
        String prevPassword = event.getPrevPassword();
        String prevEmail = event.getPrevEmail();
        String currEmail = event.getCurrEmail();
    
        if (prevEmail != currEmail) {
            Email email_info = new Email(null, null, null, null, null, null, null, null);
            email_info.setRecipientEmail(prevEmail);
            email_info.setRecipientId(event.getUserId());
            email_info.setSenderEmail("no-reply@xxxx.io");
            email_info.setSubject("Email removal");
            email_info.setBodyText("This email is removed from our account registration system");
            

            Email modified_email = new Email(null, null, null, null, null, null, null, null);
            modified_email.setRecipientEmail(currEmail);
            modified_email.setRecipientId(event.getUserId());
            modified_email.setSenderEmail("no-reply@xxxx.io");
            modified_email.setSubject("Update email");
            modified_email.setBodyText("This email is added to your account in our registration system");

            emailSrvc.saveOrUpdate(email_info);
            emailSrvc.saveOrUpdate(modified_email);

            emailSrvc.sendEmail(email_info);
            emailSrvc.sendEmail(modified_email);
        }

        if (prevPassword != currPassword) {
            Email email = new Email(null, null, null, 
                        null, null, null, null, null);
            email.setRecipientEmail(currEmail);
            email.setRecipientId(event.getUserId());
            email.setSenderEmail("no-reply@xxxx.io");
            email.setSubject("Password Reset");
            email.setBodyText("Your password was changed last few minutes. If it were not you, please check your activity in our system!");

            emailSrvc.saveOrUpdate(email);
            emailSrvc.sendEmail(email);
        }

        logger.info("Email sent successfully...");
    }

}
