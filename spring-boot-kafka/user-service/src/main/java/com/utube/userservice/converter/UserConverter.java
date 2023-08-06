package com.utube.userservice.converter;

import java.util.ArrayList;

import com.utube.userservice.entity.User;
import com.utube.userservice.form.UserForm;


public class UserConverter {

    public static UserForm maptoUserForm(User user)  {
        Long id = user.getUserId();
        String name; String email; String password; String country; String phone;
        ArrayList<Long> threads;
        name = user.getUserName(); 
        email = user.getUserEmail();
        password = user.getUserPassword();
        country = user.getUserCountry();
        phone = user.getUserPhone();
        threads = user.getEmailThreads();

        UserForm userForm = new UserForm();
        userForm.setUserId(id);
        userForm.setUserName(name);
        userForm.setUserEmail(email);
        userForm.setUserPassword(password);
        userForm.setUserCountry(country);
        userForm.setUserPhone(phone);
        userForm.setEmailThreads(threads);

        return userForm;
    }

    public static User maptoUser(UserForm userForm) {
        Long id = userForm.getUserId();
        String name; String email; String password; String country; String phone;
        // ArrayList<Long> threads;
        name = userForm.getUserName(); 
        email = userForm.getUserEmail();
        password = userForm.getUserPassword();
        country = userForm.getUserCountry();
        phone = userForm.getUserPhone();
        // threads = userForm.getEmailThreads();
        
        User user = new User();
        user.setUserId(id);
        user.setUserName(name);
        user.setUserEmail(email);
        user.setUserPassword(password);
        user.setUserCountry(country);
        user.setUserPhone(phone);
        // user.setEmailThreads();

        return user;
    }
}
