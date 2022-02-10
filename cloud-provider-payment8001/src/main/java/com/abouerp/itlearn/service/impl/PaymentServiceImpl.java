package com.abouerp.itlearn.service.impl;

import com.abouerp.itlearn.dao.PaymentDao;
import com.abouerp.itlearn.entities.Payment;
import com.abouerp.itlearn.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Abouerp
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
