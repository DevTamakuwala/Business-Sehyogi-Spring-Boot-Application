package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.PaymentRepository;
import com.businesssehyogi.BusinessSehyogi.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/getPayments")
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/getPayment/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addPayment")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }

    @PutMapping("/updatePayment/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
        Optional<Payment> paymentOptional = paymentRepository.findById(id);
        if (paymentOptional.isPresent()) {
            Payment payment = paymentOptional.get();
            payment.setAmount(paymentDetails.getAmount());
            payment.setPaymentDateTime(paymentDetails.getPaymentDateTime());
            payment.setTransactionId(paymentDetails.getTransactionId());
            payment.setUsers(paymentDetails.getUsers());
            payment.setPosts(paymentDetails.getPosts());
            return ResponseEntity.ok(paymentRepository.save(payment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
