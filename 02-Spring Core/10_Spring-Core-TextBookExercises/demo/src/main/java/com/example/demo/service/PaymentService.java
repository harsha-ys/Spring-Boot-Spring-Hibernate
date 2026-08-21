package com.example.demo.service;

import com.example.demo.model.NotEnoughMoneyException;
import com.example.demo.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentDetails pD;

    PaymentService(PaymentDetails pD){this.pD = pD;}

    public PaymentDetails processPayment() {
        pD.setAmount(20.3);
        return pD;
    }
}
