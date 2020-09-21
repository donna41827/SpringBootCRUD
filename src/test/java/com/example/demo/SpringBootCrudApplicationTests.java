package com.example.demo;

import javax.activation.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringBootCrudApplicationTests {

	@Autowired
	DataSource dataSource;
	
	@Test
	void contextLoads() {
		System.out.println(dataSource.getClass());
		
	}

}
