package com.example.service;

import com.example.model.PaymentDetails;
import com.example.exceptions.NotEnoughMoneyException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
