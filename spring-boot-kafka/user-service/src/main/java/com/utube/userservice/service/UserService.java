package com.utube.userservice.service;

// import java.util.ArrayList;
import java.util.List;

import com.utube.userservice.entity.User;
import com.utube.userservice.form.UserForm;

public interface UserService {
    public List<User> listAll();
    public User getById(Long id);
    public User create(UserForm user);
    public void saveOrUpdate(User user);
    public void deleteById(Long id);
    public void saveOrUpdateUserForm(UserForm userForm);
}
