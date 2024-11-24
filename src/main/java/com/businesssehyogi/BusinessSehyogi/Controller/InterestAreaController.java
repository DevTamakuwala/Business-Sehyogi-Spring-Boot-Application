package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.InterestAreaRepository;
import com.businesssehyogi.BusinessSehyogi.model.InterestArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class InterestAreaController {

    @Autowired
    InterestAreaRepository interestAreaRepository;

    @GetMapping("/getArea")
    public List<InterestArea> getAreas() {
        return interestAreaRepository.findAll();
    }

    @GetMapping("/addArea")
    public InterestArea addArea(@RequestBody InterestArea interestArea) {
        return interestAreaRepository.save(interestArea);
    }

    @DeleteMapping("/removeArea/{interestAreaId}")
    public String deleteInterestArea(@PathVariable("interestAreaId") int interestAreaId) {
        if (interestAreaRepository.existsById(interestAreaId)) {
            interestAreaRepository.deleteById(interestAreaId);
            return "Interest Area Deleted Successfully..!!";
        } else {
            return "Interest Area not found. Try again.";
        }
    }
}
