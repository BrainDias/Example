package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    final UserRepository userRepository;
    final PasswordEncoder encoder;

    @GetMapping("/{id}")
    public ResponseEntity<User> userById(@PathVariable Long id){
        Optional<User>user=userRepository.findById(id);
        if(user.isPresent()) return new ResponseEntity<>(user.get(),HttpStatus.FOUND);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/")
    public ResponseEntity<User> userById(@RequestParam String firstName,
                                         @RequestParam String lastName){
        Optional<User>user=userRepository.findByFirstNameAndLastName(firstName,lastName);
        if(user.isPresent()) return new ResponseEntity<>(user.get(),HttpStatus.FOUND);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<User>> allUsers(){
        Iterable<User> users=userRepository.findAll();
        return new ResponseEntity<>(users,HttpStatus.FOUND);
    }
    @PostMapping("/")
    public HttpStatus signUp(@RequestBody User user){
        //TODO Check if all attributes are present
//        userRepository.save(user);
        return HttpStatus.CREATED;
    }

    @GetMapping("/online/{count}")
    public ResponseEntity<Iterable<User>> onlineUsers(@PathVariable int count){
        PageRequest pageRequest = PageRequest.of(0,count);
        return new ResponseEntity<>(userRepository.findAllByOnline(pageRequest),HttpStatus.FOUND);
    }

    @GetMapping("/trialexpired/{count}")
    public ResponseEntity<Iterable<User>> usersWhosTrialExpired(@PathVariable int count){
        PageRequest pageRequest = PageRequest.of(0,count);
        return new ResponseEntity<>(userRepository.findAllByTrialExpired(pageRequest),HttpStatus.FOUND);
    }
    @DeleteMapping("/")
    public HttpStatus deleteAccount(){
        //TODO Make application store the user session so that it would know which user to delete
//        userRepository.delete(user);
        return HttpStatus.GONE;
    }
    @PatchMapping("/trial")
    public HttpStatus startTrial(){
//        User user = userRepository.find(?);
//        user.setTrialExpired(false);
//        userRepository.save(user);
        return HttpStatus.ACCEPTED;
    }
}
