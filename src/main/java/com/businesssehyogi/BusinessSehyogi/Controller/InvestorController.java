package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.InvestorRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.LikesRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.UserRepository;
import com.businesssehyogi.BusinessSehyogi.model.Investor;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class InvestorController {

    @Autowired
    InvestorRepository repo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LikesRepository likesRepository;

    @GetMapping("/getInvestors")
    public List<Investor> getInvestor() {
        return repo.findAll();
    }

    @GetMapping("/getInvestor/{userId}")
    public Investor getInvestor(@PathVariable("userId") int userId) {
        User user = userRepository.findByUserId(userId).orElse(null);
        if (user == null || user.getCategory().equals("Founder")) {
            return null;
        } else {
            return repo.findByUserId(user);
        }
    }

    @PostMapping("/addInvestor")
    public Investor addInvestor(@RequestBody Investor investor) {
        return repo.save(investor);
    }
}
