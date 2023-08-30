package com.packt.cardatabase;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CardatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
    }
}
