package com.abouerp.itlearn.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Abouerp
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced      //开启负载均衡   修改了url后要加这个注解，不然的不知道对应哪个程序会出bug
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
