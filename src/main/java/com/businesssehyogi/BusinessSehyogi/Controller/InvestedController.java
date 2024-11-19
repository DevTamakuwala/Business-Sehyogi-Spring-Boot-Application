package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.InvestedRepository;
import com.businesssehyogi.BusinessSehyogi.model.Invested;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
