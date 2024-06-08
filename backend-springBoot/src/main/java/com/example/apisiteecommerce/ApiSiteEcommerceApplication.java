package com.example.apisiteecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ApiSiteEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiSiteEcommerceApplication.class, args);
    }

}
