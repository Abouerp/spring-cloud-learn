package com.abouerp.itlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Abouerp
 */
@SpringBootApplication
@EnableDiscoveryClient          //该注解用于向使用consul或者zookeeper作为注册中心是注册服务
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
