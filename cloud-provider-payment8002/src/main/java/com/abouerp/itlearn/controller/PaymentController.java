package com.abouerp.itlearn.controller;

import com.abouerp.itlearn.beans.ResultBean;
import com.abouerp.itlearn.entities.Payment;
import com.abouerp.itlearn.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * @author Abouerp
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping
    public ResultBean create(@RequestBody Payment payment){
        return ResultBean.ok(paymentService.create(payment)+serverPort);
    }

    @GetMapping(value = "/{id}")
    public ResultBean getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return ResultBean.ok(payment+serverPort+"success");
        } else {
            return ResultBean.ok(payment+serverPort+"fail");
        }
    }
}
