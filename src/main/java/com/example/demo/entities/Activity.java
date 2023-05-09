package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.lang.NonNull;

@Entity
@Data
@NoArgsConstructor(force = true)
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @NonNull
    private String name;
    @NonNull
    private Region region;
    @NonNull
    private int savedPeople;
    @NonNull
    private int volunteers;
    @NonNull
    private int fundsNeeded;
    @CreditCardNumber
    private  String creditCardNumber;

    private enum Region{WORLDWIDE,AFRICA,MIDDLE_EAST,CENTRAL_AMERICA,SOUTHEATH_ASIA}
}
