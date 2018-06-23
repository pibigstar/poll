package com.pibigstar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pibigstar.dao")
public class PollApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollApplication.class, args);
	}
}
