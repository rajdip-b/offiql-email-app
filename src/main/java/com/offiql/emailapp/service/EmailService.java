package com.offiql.emailapp.service;

import com.offiql.emailapp.entity.Email;
import com.offiql.emailapp.exception.UserNotFoundException;

public interface EmailService {

    Long postEmail(Email email, Long userId) throws UserNotFoundException;

    Long getEmailCount(Long userId) throws UserNotFoundException;

}
