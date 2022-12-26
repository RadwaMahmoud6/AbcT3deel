package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entities.CustomerEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

	Optional<CustomerEntity> findByEmail(String email);

}
