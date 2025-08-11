package com.liteBank.data.repository;

import com.liteBank.data.models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @Sql(scripts = {"/db/data.sql"})
    void findByAccountNumber() {
       Optional<Account> optionalAccount = accountRepository.findByAccountNumber("0123456789");
       Account account = optionalAccount.orElseThrow(RuntimeException::new);
       assertEquals("12345", account.getId());
       assertEquals("0123456789", account.getAccountNumber());
       assertNotNull(account);
    }
}