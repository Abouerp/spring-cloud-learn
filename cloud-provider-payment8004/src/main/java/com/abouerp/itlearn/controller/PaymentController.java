package com.abouerp.itlearn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Abouerp
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String test(){
        return "SpringCloud With Zookeeper: "+serverPort+"  "+ UUID.randomUUID().toString();
    }


}
