//package com.businesssehyogi.BusinessSehyogi.Controller;
//
//import com.businesssehyogi.BusinessSehyogi.Repository.ResultRepo;
//import com.businesssehyogi.BusinessSehyogi.model.Result;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class ResultController {
//    @Autowired
//    ResultRepo resultRepo;
//
//    @GetMapping("/getAlienById/{alienId}")
//    public List<Result> getResultByAlien(@PathVariable("alienId") Integer alienId){
//        return resultRepo.findResultByAlienId(alienId);
//    }
//}
