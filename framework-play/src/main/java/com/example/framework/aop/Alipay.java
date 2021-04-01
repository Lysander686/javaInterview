package com.example.framework.aop;

public class Alipay implements Payment {

    private Payment payment;

    public Alipay(Payment payment) {
        this.payment = payment;
    }

    public void beforePay(){
        System.out.println("Take money from bank.");
    }

    public void afterPay(){
        System.out.println("Transfer money to the merchant.");
    }




    @Override
    public void pay() {
//        System.out.println("pay via aliPay");
        beforePay();
        payment.pay();
        afterPay();
    }
}
