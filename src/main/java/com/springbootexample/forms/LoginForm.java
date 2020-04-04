package com.springbootexample.forms;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginForm {
    @NotNull
    @Size(min = 6, message = "6 characters minimum")
    private String username;

    @NotNull
    @Size(min = 6, message = "6 characters minimum")
    private String password;

    private boolean rememberMe;
}