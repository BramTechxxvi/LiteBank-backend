package com.liteBank.data.repository;

import com.liteBank.data.models.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Page<Transaction> retrieveByAccountNumber(String accountNumber, Pageable pageable);
}