package com.liteBank;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LiteBankApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testCanConnectToDataBase() {
		try(HikariDataSource hikariDaraSource = new HikariDataSource()) {
			hikariDaraSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
			hikariDaraSource.setUsername();
		} catch() {

		}
	}

}
