package com.example.framework.aop;

public class PaymentImpl implements Payment {
    @Override
    public void pay() {
        System.out.println("user pay~");
    }
}
