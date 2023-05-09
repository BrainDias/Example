package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);
    Iterable<User> findAllByOnline(Pageable pageable);
    Iterable<User> findAll();
    Optional<User> findById(Long id);
}
