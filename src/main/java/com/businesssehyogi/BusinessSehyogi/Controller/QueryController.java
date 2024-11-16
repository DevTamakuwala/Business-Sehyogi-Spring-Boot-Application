package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.QueryRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.UserRepository;
import com.businesssehyogi.BusinessSehyogi.Service.sendOTPEmail;
import com.businesssehyogi.BusinessSehyogi.model.Queries;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class QueryController {

    @Autowired
    QueryRepository queryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    sendOTPEmail sendMail;

    //get all queries
    //for admin
    @GetMapping("/getQueries")
    public List<Queries> getAllQueries() {
        return queryRepository.findAll();
    }

    // add new query
    //for user
    @PostMapping("/addQuery/{userId}")
    public Queries addQuery(@PathVariable("userId") int userId, @RequestParam("queryMessage") String queryMessage) {
        var date = LocalDateTime.now();
        User user = userRepository.findById(userId).orElse(new User());
        Queries queries = new Queries(user, date, queryMessage, false, false, "");
        queryRepository.save(queries);
        var queryId = queries.getQueryId();
        return queryRepository.findByQueryId(queryId);
    }

    //get one query
    //for admin
    @GetMapping("/getQuery/{queryId}")
    public Queries getOneQuery(@PathVariable("queryId") int queryId) {
        return queryRepository.findByQueryId(queryId);
    }

    // get all queries for one particular user
    // for users
    @GetMapping("/getMyQueries/{userId}")
    public List<Queries> getUserQueries(@PathVariable("userId") int userId) {
        // Fetch the user by userId
        User user = userRepository.findByUserId(userId).orElse(null);

        if (user != null) {
            // If the user is found, retrieve all queries for that user
            return queryRepository.findByUser(user);
        } else {
            // If the user is not found, return an empty list or handle as needed
            return List.of(); // Returning an empty list if the user is not found
        }
    }

    //reply to user's query
    //for Admin
    @PostMapping("/replyToQuery/{queryId}")
    public ResponseEntity<String> replyToQuery(@PathVariable("queryId") int queryId, @RequestParam("answer") String answer) {
        // Find the query by its ID
        Queries query = queryRepository.findByQueryId(queryId);

        if (!query.getIsAnswer()) {
            User user = query.getUser();
            if (!user.getEmail().isEmpty()) {
                sendMail.sendMail(user.getEmail(), user.getFirstName() + ", Here is the answer of your question", "Q:- " + query.getQuery() + "\nA: " + answer + "\nPlease feel free to ask any other query by wither replying on this main or using our website.\nThank you.\nTeam Business Sehyogi");
            }

            // If the query is found, update the status and answer fields
            if (query != null) {
                query.setIsAnswer(true);  // Marking that the query has been answered
                query.setIsSolved(true);  // Marking the query as solved
                query.setAnswer(answer);  // Setting the answer provided by the admin

                // Save the updated query in the repository
                queryRepository.save(query);

                return new ResponseEntity<>("Query answered and updated successfully!", HttpStatus.OK);
            } else {
                // If the query is not found, return an error response
                return new ResponseEntity<>("Query not found!", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Already Responded", HttpStatus.ALREADY_REPORTED);
        }
    }
}
