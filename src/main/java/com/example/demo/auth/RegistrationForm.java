package com.example.demo.auth;

import com.example.demo.entities.User;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;

public class RegistrationForm {

    private String username;

    private String password;

    private String email;

    private Long phoneNumber;

    private String creditCardNumber;

    private String CVV;

    private String zipCode;

    private String firstName;

    private String lastName;
    private String expirationDate;

    public User getUserInstance(PasswordEncoder encoder) {
        return new User(
                new Random().nextLong(), username,encoder.encode(password),
                email,phoneNumber,creditCardNumber,CVV,expirationDate,
                zipCode,firstName,lastName,false
        );
    }
}
