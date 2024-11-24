package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.InterestAreaRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.InvestorInvestedAreaRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.InvestorRepository;
import com.businesssehyogi.BusinessSehyogi.model.InterestArea;
import com.businesssehyogi.BusinessSehyogi.model.Investor;
import com.businesssehyogi.BusinessSehyogi.model.InvestorInterestedArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class InvestorInterestedAreaController {

    @Autowired
    InvestorInvestedAreaRepository investorInvestedAreaRepository;

    @Autowired
    InvestorRepository investorRepository;

    @Autowired
    InterestAreaRepository interestAreaRepository;

    @GetMapping("/getAllInvestorsInterestedAreas")
    public List<InvestorInterestedArea> getAllInvestorsInterestedAreas() {
        return investorInvestedAreaRepository.findAll();
    }

    @PostMapping("/addInvestorInterest/{interestAreaId}/{investorId}")
    public InvestorInterestedArea addInvestorInterest(@PathVariable("interestAreaId") int interestAreaId, @PathVariable("investorId") int investorId) {
        Investor investor = investorRepository.findById(investorId).orElse(null);
        InterestArea interestArea = interestAreaRepository.findById(interestAreaId).orElse(null);
        InvestorInterestedArea investorInterestedArea = new InvestorInterestedArea(interestArea, investor);
        investorInvestedAreaRepository.save(investorInterestedArea);
        return investorInterestedArea;
    }

}
