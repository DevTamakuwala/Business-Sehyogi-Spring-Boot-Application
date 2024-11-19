package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.InvestedRepository;
import com.businesssehyogi.BusinessSehyogi.model.Invested;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class InvestedController {

    @Autowired
    InvestedRepository investedRepository;

    @GetMapping("/getAllInvestments")
    public List<Invested> getAllInvestments() {
        return investedRepository.findAll();
    }

    @GetMapping("/getInvestment/{investmentId}")
    public Invested getInvestment(@PathVariable("investmentId") int investmentId) {
        return investedRepository.findByInvestId(investmentId);
    }

    @DeleteMapping("/deleteInvestment/{investmentId}")
    public String deleteInvestment(@PathVariable("investmentId") int investmentId) {
        Invested invested = investedRepository.findByInvestId(investmentId);
        if (investedRepository.existsById(investmentId)) {
            investedRepository.deleteById(investmentId);
            return "Investment Deleted successfully";
        } else {
            return "No investment found";
        }
    }
}
