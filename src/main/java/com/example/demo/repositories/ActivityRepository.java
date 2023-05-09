package com.example.demo.repositories;

import com.example.demo.entities.Activity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ActivityRepository extends PagingAndSortingRepository<Activity,Long> {
}
