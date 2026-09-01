package com.example.demo.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PaymentDetails {
    private double amount;

    public double getAmount(){return amount;}
    public void setAmount(double amount){this.amount = amount;}
}
