package com.springframework.spring6restmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.springframework.spring6restmvc.repositories")
public class Spring6RestMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring6RestMvcApplication.class, args);
    }

}
