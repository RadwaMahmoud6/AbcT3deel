package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entities.TransactionsEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface TransactionsRepo extends JpaRepository<TransactionsEntity, Integer>{
	
	List<TransactionsEntity> findByAccountNum(Integer accountNum);

}
