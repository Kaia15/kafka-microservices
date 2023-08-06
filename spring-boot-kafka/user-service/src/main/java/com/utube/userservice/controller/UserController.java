package com.utube.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utube.userservice.entity.User;
import com.utube.userservice.form.UserForm;
import com.utube.userservice.kafka.event.UserCreatedEvent;
import com.utube.userservice.kafka.event.UserSubscribedEvent;
import com.utube.userservice.kafka.event.UserUpdatedEvent;
import com.utube.userservice.kafka.producer.UserProducer;
import com.utube.userservice.repository.UserRepository;
import com.utube.userservice.service.UserServiceImpl;

@RestController
public class UserController {
    private UserServiceImpl userSrvc;
    private UserRepository userRepository;
    private UserProducer userProducer;

    public UserController(UserServiceImpl userServiceImpl, UserRepository userRepository, UserProducer userProducer) {
        this.userSrvc = userServiceImpl;
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @PostMapping("/users") 
    public User create(@RequestBody UserForm userForm) {
        User user = userSrvc.create(userForm);
        userRepository.save(user);

        UserCreatedEvent event = new UserCreatedEvent();
        event.setMessage("a new user is created!");
        event.setStatus("PENDING");
        event.setUserId(user.getUserId());
        event.setUserEmail(user.getUserEmail());
        userProducer.sendMessage(event, "user_create_topics");

        return user;
    }
    @PutMapping("/users/{userId}/subscribe")
    public void subscribe(@PathVariable Long userId, @RequestBody Long id) {
        UserSubscribedEvent event = new UserSubscribedEvent();
        
        User subscribee = userSrvc.getById(id);
        User subscriber = userSrvc.getById(userId);

        subscribee.setSubscribers(userId);
        subscriber.setSubscribees(id);
        userSrvc.saveOrUpdate(subscriber);
        userSrvc.saveOrUpdate(subscribee);

        event.setSubscribeeId(id);
        event.setSubscriberId(userId);
        event.setSubscribeeName(subscribee.getUserName());
        event.setSubscriberName(subscriber.getUserName());
        event.setMessage(String.format("You already subscribed @ %s", subscribee.getUserName()));
        event.setStatus("PENDING");

        userProducer.sendSubscriptionPayload(event, "user_subscribe_topics");

    } 

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userSrvc.getById(userId);
    }

    @PutMapping("/users/{userId}")
    public User updateUserById(@PathVariable Long userId, @RequestBody User userBody) {
        User user = userSrvc.getById(userId);
        UserUpdatedEvent event = new UserUpdatedEvent();
        event.setUserId(userId);
        event.setPrevEmail(user.getUserEmail());
        event.setPrevPassword(user.getUserPassword());

        String name = userBody.getUserName();
        String email = userBody.getUserEmail();
        String password = userBody.getUserPassword();
        String country = userBody.getUserCountry();
        String phone = userBody.getUserPhone();
        
        if (name != null) user.setUserName(name);

        if (email != null) {
            event.setCurrEmail(email);
            user.setUserEmail(email);
        } else event.setCurrEmail(user.getUserEmail());

        if (password != null) {
            event.setCurrPassword(password);
            user.setUserPassword(password);
        } else event.setCurrPassword(user.getUserPassword());

        if (country != null) user.setUserCountry(country);

        if (phone != null) {
            user.setUserPhone(phone);
        }
        userSrvc.saveOrUpdate(user);

        userProducer.sendModifiedUserPayload(event, "user_update_topics");
        return user;
    }
}
