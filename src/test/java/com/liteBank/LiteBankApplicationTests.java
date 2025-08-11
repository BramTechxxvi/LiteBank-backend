package com.liteBank;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LiteBankApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testCanConnectToDataBase() {
		try(HikariDataSource) {

		} catch() {

		}
	}

}
