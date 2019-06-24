package com.eliasnogueira.restricao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RestricaoCreditoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestricaoCreditoApplication.class, args);
    }
}
