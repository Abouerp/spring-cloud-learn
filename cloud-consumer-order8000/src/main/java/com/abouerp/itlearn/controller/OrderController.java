package com.abouerp.itlearn.controller;

import com.abouerp.itlearn.beans.ResultBean;
import com.abouerp.itlearn.entities.Payment;
import com.abouerp.itlearn.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;


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

    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public ResultBean get2(@PathVariable Long id){
        ResponseEntity<ResultBean> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/"+id, ResultBean.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return ResultBean.of(444,"fail");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size()<=0){
            return  null;
        }
        ServiceInstance serviceInstance = loadBalancer.instance(instances);
        URI uri =  serviceInstance.getUri();
        System.out.println(uri.toString());
        return restTemplate.getForObject(uri+"/payment/lb", String.class);

    }
}
