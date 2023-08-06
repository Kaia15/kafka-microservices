package com.utube.userservice.service;

import com.utube.userservice.entity.User;
import com.utube.userservice.form.UserForm;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utube.userservice.repository.UserRepository;
import com.utube.userservice.converter.UserConverter;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }
    public User getById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        // return UserConverter.maptoUserForm(user);
        return user;
    }
    public User create(UserForm userForm) {
        User user = UserConverter.maptoUser(userForm);        
        // user.setNotifications(Long.valueOf(0));
        // user.setSubscribeChannels(Long.valueOf(0));
        return user;
    }
    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }
    public void deleteById(Long id) {

    }
    public void saveOrUpdateUserForm(UserForm userForm) {

    }
}
