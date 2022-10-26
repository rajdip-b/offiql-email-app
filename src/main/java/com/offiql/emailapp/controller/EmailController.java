package com.offiql.emailapp.controller;

import com.offiql.emailapp.entity.Email;
import com.offiql.emailapp.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@Slf4j
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> postEmail(@RequestBody Email email, @PathVariable Long userId) {
        try {
            return ResponseEntity.ok(emailService.postEmail(email, userId));
        } catch (Exception e) {
            log.error("Error while posting email", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/count")
    public ResponseEntity<?> getEmailCount(@RequestParam Long userId) {
        try {
            return ResponseEntity.ok(emailService.getEmailCount(userId));
        } catch (Exception e) {
            log.error("Error while getting email count", e);
            return ResponseEntity.badRequest().build();
        }
    }

}
