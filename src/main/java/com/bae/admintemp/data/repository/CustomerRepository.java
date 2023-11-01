package com.bae.admintemp.data.repository;

import com.bae.admintemp.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByUserId(String userId);
}