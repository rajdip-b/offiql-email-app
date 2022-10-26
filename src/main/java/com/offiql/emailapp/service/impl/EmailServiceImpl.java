package com.offiql.emailapp.service.impl;

import com.offiql.emailapp.entity.Email;
import com.offiql.emailapp.exception.UserNotFoundException;
import com.offiql.emailapp.repository.EmailRepository;
import com.offiql.emailapp.repository.UserRepository;
import com.offiql.emailapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmailServiceImpl implements EmailService {

    private final UserRepository userRepository;
    private final EmailRepository emailRepository;

    @Autowired
    public EmailServiceImpl(UserRepository userRepository, EmailRepository emailRepository) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
    }

    @Override
    @Transactional
    public Long postEmail(Email email, Long userId) throws UserNotFoundException {
        var e = emailRepository.save(email);
        var u = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        u.getEmails().add(e);
        return e.getId();
    }

    @Override
    public Long getEmailCount(Long userId) throws UserNotFoundException {
        return userRepository.findById(userId).map(user -> (long) user.getEmails().size()).orElseThrow(UserNotFoundException::new);
    }
}
