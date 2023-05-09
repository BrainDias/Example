package com.example.demo.repositories;

import com.example.demo.entities.Donation;
import com.example.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DonationRepository extends CrudRepository<Donation,Long> {
    Iterable<Donation> findDonationsByUser(User user);
}
