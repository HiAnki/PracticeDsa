package com.ankita.payment;

public class PaymentServiceFactory {

    String googleUpiIdPrefix = "google";
    String phonePayUpiIdPrefix = "phonePay";
//    private PaymentService GooglePayPaymentService = new GooglePayPaymentService();
//    private PaymentService PhonePayUpiService = new P;

    PaymentService getPaymentService(String upiIdPrefix) {
        if (upiIdPrefix == googleUpiIdPrefix) {
            return new GooglePayPaymentService();
        } else if (upiIdPrefix == phonePayUpiIdPrefix) {
            return new PhonePayUpiService();
        } else {
            throw new RuntimeException("invalid upi id");
        }

    }

}
