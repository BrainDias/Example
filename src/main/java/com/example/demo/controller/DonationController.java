package com.example.demo.controller;

import com.example.demo.entities.Activity;
import com.example.demo.entities.Donation;
import com.example.demo.repositories.DonationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/donations")
public class DonationController {

    private final DonationRepository donationRepository;

    @PostMapping("/current/{amount}")
    public HttpStatus makeDonation(@RequestParam Activity activity,
                                   @PathVariable int amount){
        //TODO Check user's credit card balance
//        if(amount>checkBalance(user.creditCardNumber))
//            return HttpStatus.NOT_ACCEPTABLE
        Donation donation=new Donation(user,activity,amount, Date.valueOf(LocalDate.now()));
        donationRepository.save(donation);
        return HttpStatus.ACCEPTED;
    }
    @GetMapping("/my")
    public ResponseEntity<Iterable<Donation>> userDonations(){
        return new ResponseEntity<>(donationRepository.findDonationsByUser(user),HttpStatus.FOUND);
    }
}
