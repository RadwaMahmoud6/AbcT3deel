package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.AccountsEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface AccountsRepo extends JpaRepository<AccountsEntity , Integer> {

	 List<AccountsEntity> findByCustomerNum(Integer customerNum);
}
