package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GreetingServiceTests {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private GreetingService service;

    @Test
    void greetingServiceTest(){
        Mockito.when(userRepository.findUserByName("Mary")).thenReturn(new User(1L,"Mrs. ","Mary"));
        Assertions.assertEquals(service.printHello("Mary"),"Hello Mrs. Mary!");
    }
}
