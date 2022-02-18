package com.abouerp.itlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Abouerp
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain8000 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain8000.class, args);
    }
}
