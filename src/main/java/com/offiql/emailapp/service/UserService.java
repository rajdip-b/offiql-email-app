package com.offiql.emailapp.service;

import com.offiql.emailapp.entity.User;
import com.offiql.emailapp.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    Long saveUser(User user);

    User getUserById(Long userId) throws UserNotFoundException;

    List<User> getAllUsers();

}
