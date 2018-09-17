package com.sheet.work.time.table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.sheet.work.time.table")

public class TableApplication {

	public static void main(String[] args) {
		SpringApplication.run(TableApplication.class, args);
	}
}
