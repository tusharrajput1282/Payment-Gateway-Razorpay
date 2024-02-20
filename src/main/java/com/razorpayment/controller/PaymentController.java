package com.razorpayment.controller;

import com.razorpay.*;
import com.razorpayment.payload.OrderRequest;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {

    //http://localhost:8080/api/create-order
    @PostMapping("/create-order")
    public String createOrder(@RequestBody OrderRequest order) throws Exception {
        RazorpayClient razorpay = new RazorpayClient("rzp_test_ixrDMZpbUltXc7" ,"Ut2bFoAhR2Pr7ENBJHxLIqlp");

        JSONObject orderRequest = new JSONObject();                         //In this object we supply the details of payload
        orderRequest.put("amount",order.getAmount()*100);                   //This amount is always in Paise.This is always in the lower term( Ex:- 500rupees * 100 = 50000 paise)
        orderRequest.put("currency","INR");
        orderRequest.put("receipt", "psa123");
        JSONObject notes = new JSONObject();
        notes.put("notes_key_1","Tea, Earl Grey, Hot");
        notes.put("notes_key_1","Tea, Earl Grey, Hot");
        orderRequest.put("notes",notes);

        Order orderResponse = razorpay.orders.create(orderRequest);
//        System.out.println(orderResponse);
        return orderResponse.get("id").toString();                          //Here we will be returning OrderId
    }
}
