package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private  String username;
    @NonNull
    private  String password;
    @Pattern(regexp = "^*@(gmail)|(yahoo).(com)|(ua)$")
    private  String email;
    @Digits(integer = 10,fraction = 0,message = "Invalid phone number")
    private  Long phoneNumber;
    @CreditCardNumber
    public String creditCardNumber;
    @Digits(integer = 3,fraction = 0,message = "Invalid CVV")
    private  String CVV;
    @Pattern(regexp = "^(0[1-9])|(1[0-2])/2[3-9]$")
    private  String expirationDate;
    @Digits(integer = 5,fraction = 0,message = "Invalid ZIP")
    private  String zipCode;
    @NonNull
    private  String firstName;
    @NonNull
    private  String lastName;
    @NonNull
    private  boolean isOnline;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
