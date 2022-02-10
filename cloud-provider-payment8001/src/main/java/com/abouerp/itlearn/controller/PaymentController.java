package com.abouerp.itlearn.controller;

import com.abouerp.itlearn.beans.ResultBean;
import com.abouerp.itlearn.entities.Payment;
import com.abouerp.itlearn.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author Abouerp
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResultBean create(@RequestBody Payment payment){
        return ResultBean.ok(paymentService.create(payment));
    }

    @GetMapping(value = "/{id}")
    public ResultBean getPaymentById(@PathVariable("id") Long id){
        return ResultBean.ok(paymentService.getPaymentById(id));
    }
}
