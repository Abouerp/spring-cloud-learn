package com.abouerp.itlearn.service;

import com.abouerp.itlearn.beans.ResultBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Abouerp
 */
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     *  getMapping 的路径跟payment8001项目的controller 的那个路径相同，参数也一样
     */
    @GetMapping(value = "/payment/{id}")
    ResultBean getPaymentById(@PathVariable("id") Long id);
}
