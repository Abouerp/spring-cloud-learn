package com.abouerp.itlearn.controller;

import com.abouerp.itlearn.beans.ResultBean;
import com.abouerp.itlearn.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Abouerp
 */
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public ResultBean getPaymentById(@PathVariable Long id){
        return paymentFeignService.getPaymentById(id);
    }
}
