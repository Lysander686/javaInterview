package com.example.framework.aop;

public class ProxyDemo {
    public static void main(String[] args) {
        Payment proxy = new Alipay(new PaymentImpl());
        proxy.pay();

    }
}
