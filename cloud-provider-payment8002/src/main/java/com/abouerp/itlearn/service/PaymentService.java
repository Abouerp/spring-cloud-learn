package com.abouerp.itlearn.service;

import com.abouerp.itlearn.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Abouerp
 */
public interface PaymentService {

    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
