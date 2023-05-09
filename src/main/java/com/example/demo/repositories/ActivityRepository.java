package com.example.demo.repositories;

import com.example.demo.entities.Activity;
import com.example.demo.entities.ActivityDescription;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ActivityRepository extends PagingAndSortingRepository<Activity,Long> {
    Optional<ActivityDescription>
}
