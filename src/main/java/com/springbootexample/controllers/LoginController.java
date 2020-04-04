package com.springbootexample.controllers;

import com.springbootexample.dtos.GenericResponseObject;
import com.springbootexample.entities.User;
import com.springbootexample.forms.LoginForm;
import com.springbootexample.services.user.UserServiceImpl;
import com.springbootexample.utils.ConstantsUtils;
import com.springbootexample.utils.jwt.JwtUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginController {

    private static final Logger logger = LogManager.getLogger(LoginController.class);
    private UserServiceImpl userServiceImpl;
    private JwtUtil jwtUtil;

    @Autowired
    public LoginController(UserServiceImpl userServiceImpl, JwtUtil jwtUtil) {
        this.userServiceImpl = userServiceImpl;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping(value = "/api/login")
    public ResponseEntity<GenericResponseObject<Object>> index() {
        return ResponseEntity.ok().body(GenericResponseObject.builder()
                .timestamp(LocalDateTime.now())
                .message(ConstantsUtils.getSUCCESS())
                .status(ConstantsUtils.getResponseSuccess())
                .build());
    }

    @PostMapping(value = "/api/checkLogin")
    public ResponseEntity<GenericResponseObject<Object>> login(@ModelAttribute("loginForm") @Valid LoginForm loginForm, BindingResult result) {
        try {
            String username = loginForm.getUsername();
            String password = loginForm.getPassword();
            if (result.hasErrors()) {
                return ResponseEntity.ok().body(GenericResponseObject.builder()
                        .timestamp(LocalDateTime.now())
                        .message(ConstantsUtils.getFormErrors())
                        .status(ConstantsUtils.getResponseBadRequest())
                        .build()
                );
            } else {
                Optional<User> optionalUser = userServiceImpl.isValidUser(username, password);
                if (optionalUser.isPresent()) {
                    String token = jwtUtil.generateToken(optionalUser.get());
                    return ResponseEntity.ok().body(GenericResponseObject.builder()
                            .timestamp(LocalDateTime.now())
                            .message(ConstantsUtils.getSUCCESS())
                            .status(ConstantsUtils.getResponseSuccess())
                            .data(token)
                            .build()
                    );
                } else {
                    return ResponseEntity.ok().body(GenericResponseObject.builder()
                            .timestamp(LocalDateTime.now())
                            .message(ConstantsUtils.getUserInvalidMsg())
                            .status(ConstantsUtils.getResponseBadRequest())
                            .build()
                    );
                }
            }
        } catch (Exception e) {
            logger.error(e);
            return ResponseEntity.ok()
                    .body(GenericResponseObject.builder()
                            .timestamp(LocalDateTime.now())
                            .message(ConstantsUtils.getInternalServerErrorMsg())
                            .status(ConstantsUtils.getResponseInternalServerError())
                            .build()
                    );
        }
    }

}