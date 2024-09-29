package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.InvestorRepository;
import com.businesssehyogi.BusinessSehyogi.model.Investor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class InvestorController {

    @Autowired
    InvestorRepository repo;

    @GetMapping("/getInvestors")
    public List<Investor> getInvestor() {
        return repo.findAll();
    }

    @PostMapping("/addInvestor")
    public Investor addInvestor(@RequestBody Investor investor) {
        return repo.save(investor);
    }
}
