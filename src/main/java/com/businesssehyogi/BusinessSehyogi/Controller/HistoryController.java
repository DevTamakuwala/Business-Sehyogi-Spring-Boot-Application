package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.DTO.HistoryRequest;
import com.businesssehyogi.BusinessSehyogi.Repository.HistoryRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.UserRepository;
import com.businesssehyogi.BusinessSehyogi.model.History;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class HistoryController {

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    UserRepository userRepository;

    // get all History
    // for admin
    @GetMapping("/getHistory")
    public List<History> getHistory() {
        return historyRepository.findAll();
    }

    // add data in history table
    // for founder and investor
    @PostMapping("/addHistory")
    public ResponseEntity<Object> addHistory(@RequestBody HistoryRequest historyRequest) {
        Optional<User> user = userRepository.findByUserId(historyRequest.getUser());
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        History history = new History();
        System.out.println("Change date time:- " + LocalDateTime.now());
        history.setChangeDate(LocalDateTime.now());
        history.setUser(user.get());
        history.setOldContact(historyRequest.getOldContact());
        history.setOldEmail(historyRequest.getOldEmail());
        System.out.println("old password:- " + historyRequest.getOldPassword());
        history.setOldPassword(historyRequest.getOldPassword());
        History savedHistory = historyRepository.save(history);
        return ResponseEntity.ok(savedHistory);
    }

    // get all histories of one user
    // for admin
    @GetMapping("/getHistory/user/{userId}")
    public List<History> getHistoryForOneUser(@PathVariable("userId") int userId) {
        return historyRepository.findByUserUserId(userId);
    }
}
