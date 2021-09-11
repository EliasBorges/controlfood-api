package com.api.controlfood;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ControlfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlfoodApplication.class, args);

		log.info("\n------------------------\n"
				+ "      Control Food\n"
				+ "------------------------"
		);
	}

}
