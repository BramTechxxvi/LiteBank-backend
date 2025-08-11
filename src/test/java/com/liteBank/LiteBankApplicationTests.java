package com.liteBank;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class LiteBankApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testCanConnectToDataBase() {
		try(HikariDataSource hikariDataSource = new HikariDataSource()) {
			hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/lite_bank");
			hikariDataSource.setUsername("postgres");
			hikariDataSource.setPassword("Dangers$123");

			Connection connection = hikariDataSource.getConnection();
			assertNotNull(connection);
		} catch(Exception e) {
			assertNotNull(e);
		}
	}
}