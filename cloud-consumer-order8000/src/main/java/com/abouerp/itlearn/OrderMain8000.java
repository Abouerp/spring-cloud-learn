package com.abouerp.itlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Abouerp
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMain8000 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8000.class, args);
    }
}
