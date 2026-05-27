package com.ankita.payment;

public class GooglePayPaymentService implements PaymentService {
    @Override
    public void pay(String upiId, int userId) {
        System.out.println("processing payment at google pay for upiId" + upiId);
    }
}
