package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.sql.Date;

@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @NonNull
    private  User user;
    @NonNull
    private  Activity activity;
    @NonNull
    private  int amount;
    @NonNull
    private  Date date;
}
