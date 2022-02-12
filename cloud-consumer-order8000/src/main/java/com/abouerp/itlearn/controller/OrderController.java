package com.abouerp.itlearn.controller;

import com.abouerp.itlearn.beans.ResultBean;
import com.abouerp.itlearn.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author Abouerp
 */
@RestController
//@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";    //这个url根据eureka server页面中的Application来得到，即对应程序name


    @GetMapping("/consumer/payment/create")
    public ResultBean create(Payment payment){

        return restTemplate.postForObject(PAYMENT_URL+"/payment",payment,ResultBean.class);
//        return ResultBean.ok(WebClient.create().post().uri(PAYMENT_URL+"/payment")
//                .retrieve().bodyToMono(String.class)
//                .map(it -> {
//                    try {
//                        return JsonUtils.readValue(it, Payment.class);
//                    }catch (Exception e){
//                        if (log.isErrorEnabled()) {
//                            log.error("{}", it, e);
//                        }
//                        return new Payment();
//                    }
//                }).block()
//        );
    }

    @GetMapping("/consumer/payment/{id}")
    public ResultBean get(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id, ResultBean.class);
    }
}
