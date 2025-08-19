package com.liteBank.data.repository;

import com.liteBank.data.models.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query("select t from Transaction t where t.accountNumber =:accountNumber")
    Page<Transaction> retrieveTransactionsByAccountNumber(String accountNumber, Pageable pageable);

    List<Transaction> findTransactionByAccountNumber(String accountNumber);

}