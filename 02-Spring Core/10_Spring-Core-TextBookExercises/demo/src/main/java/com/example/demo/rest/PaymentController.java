package com.example.demo.rest;

import com.example.demo.model.PaymentDetails;
import com.example.demo.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class PaymentController {
/*    private static Logger logger =
            Logger.getLogger(PaymentController.class.getName());
    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(
            @RequestBody PaymentDetails paymentDetails) {
        logger.info("Received payment " + paymentDetails.getAmount());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
    }*/

    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment() {
        PaymentDetails paymentDetails = paymentService.processPayment();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}
