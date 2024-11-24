package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.DTO.PaymentRequest;
import com.businesssehyogi.BusinessSehyogi.Repository.PaymentRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.PostRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.UserRepository;
import com.businesssehyogi.BusinessSehyogi.model.Payment;
import com.businesssehyogi.BusinessSehyogi.model.Post;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/getPayments")
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/getPayment/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/addPayment")
    public Payment createPayment(@RequestBody PaymentRequest paymentRequest) {
        User user = userRepository.findByUserId(paymentRequest.getUsers()).orElse(null);
        Post post = postRepository.findByPostId(paymentRequest.getPosts());

        if (user != null && post != null) {
            Set<User> users = new HashSet<>();
            users.add(user);

            Set<Post> posts = new HashSet<>();
            posts.add(post);

            // Remove the payment_id from the constructor, as it will be generated automatically
            Payment payment = new Payment(users, posts, paymentRequest.getAmount(), paymentRequest.getPaymentDateTime(), paymentRequest.getTransactionId());

            // Save the payment and return it
            return paymentRepository.save(payment);
        } else {
            return null;
        }
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
