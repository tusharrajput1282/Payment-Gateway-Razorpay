package com.razorpayment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class PaymentCheckout {

    //localhost:8080/payment             //Load that link in chrome browser
    @GetMapping("/payment")
    public String showPaymentPage() {

        // Generate orderId and amount dynamically or retrieve from database
//        String orderId = "order_NcoDn6bsQaoKGP";
//
//        int amount = 50000;          //Amount in paise (e.g., 500 INR)
//
//        // Pass orderId and amount to the Thymeleaf template
//        model.addAttribute("orderId", orderId);
//        model.addAttribute("amount", amount);

        return "payment-request";
    }
}