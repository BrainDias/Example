package com.example.demo.controller;

import com.example.demo.entities.Activity;
import com.example.demo.repositories.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/activities")
public class ActivityController {
    private final ActivityRepository activityRepository;
    @GetMapping("/{amount}")
    public ResponseEntity<Iterable<Activity>> getCurrentActivities(@PathVariable int amount){
        return new ResponseEntity<>(activityRepository.findAll(PageRequest.of(0,amount)), HttpStatus.FOUND);
    }
    @GetMapping("/")
    public ResponseEntity<ActivityDescription> getActivityDescription(@RequestParam String activityName){
        return new ResponseEntity<>(activityRepository.findDescriptionByName(activityName), HttpStatus.FOUND);
    }
}
