package com.abouerp.itlearn;

import com.abouerp.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


/**
 * @author Abouerp
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)     //采用替换负载均衡算法需要添加这个注解
public class OrderMain8000 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8000.class, args);
    }
}
