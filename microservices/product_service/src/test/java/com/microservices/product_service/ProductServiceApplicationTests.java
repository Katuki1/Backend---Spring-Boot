package com.microservices.product_service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.MySQLR2DBCDatabaseContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class ProductServiceApplicationTests {

	@Container
	static MySQLR2DBCDatabaseContainer mySQLR2DBCDatabaseContainer =
			new MySQLR2DBCDatabaseContainer(new MySQLContainer<>("mysql") );

	@BeforeAll
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dymDynamicPropertyRegistry){
		dymDynamicPropertyRegistry.add("spring.datasource.url", mySQLR2DBCDatabaseContainer::getDependencies);
	}

//	@BeforeAll
//	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
//		dynamicPropertyRegistry.add("spring.data.mysqldb.uri",
//				() -> "r2dbc:mysql://" + mySQLR2DBCDatabaseContainer.getContainerIpAddress() + ":"
//						+ mySQLR2DBCDatabaseContainer.getFirstMappedPort() + "/"
//						+ mySQLR2DBCDatabaseContainer.getDatabaseName());
//	}

	@Test
	void contextLoads() {
	}

}
