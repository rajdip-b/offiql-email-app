package com.offiql.emailapp.service.impl;

import com.offiql.emailapp.entity.User;
import com.offiql.emailapp.exception.UserNotFoundException;
import com.offiql.emailapp.repository.UserRepository;
import com.offiql.emailapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Long saveUser(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public User getUserById(Long userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
