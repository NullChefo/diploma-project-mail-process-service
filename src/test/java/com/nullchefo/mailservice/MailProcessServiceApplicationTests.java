package com.nullchefo.mailservice;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
@SpringBootTest
@Testcontainers
class MailProcessServiceApplicationTests {

	@Container
	private final PostgreSQLContainer<?> postgresqlContainer = new PostgreSQLContainer()
			.withDatabaseName("foo")
			.withUsername("foo")
			.withPassword("secret");

	@Before
	void before() {
		postgresqlContainer.start();
	}

	@After
	void after() {
		postgresqlContainer.stop();
	}

	@Test
	void contextLoads() {
	}

}
