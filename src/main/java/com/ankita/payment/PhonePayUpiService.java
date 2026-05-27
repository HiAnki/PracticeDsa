package com.ankita.payment;

public class PhonePayUpiService implements PaymentService{
    @Override
    public void pay(String upiId, int userId) {
        System.out.println("processing payment at phone pay for upiId" + upiId);
    }
}
