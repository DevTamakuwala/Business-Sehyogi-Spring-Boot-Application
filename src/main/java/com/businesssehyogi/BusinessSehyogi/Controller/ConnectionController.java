package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.ConnectionsRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.UserRepository;
import com.businesssehyogi.BusinessSehyogi.model.Connections;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class ConnectionController {

    @Autowired
    ConnectionsRepository connectionsRepository;

    @Autowired
    UserRepository userRepository;

    //add new connection
    @PostMapping("/addConnection/{userId}/{coFounderOrInvestorUser}")
    public Connections addConnection(@PathVariable("userId") int followByUser, @PathVariable("coFounderOrInvestorUser") int followToUser) {
        // getting the user's information who initiate the follow
        User FollowByUser = userRepository.findByUserId(followByUser).orElse(null);
        // getting the user's information who get followed by the other user either can be a founder or investor
        User FollowToUser = userRepository.findByUserId(followToUser).orElse(null);
        // Status of the follow request
        var Status = "Pending";
        // adding new connection in table
        Connections connections = new Connections(FollowByUser, FollowToUser, Status);
        // saving the data in the table
        connectionsRepository.save(connections);
        var connection = FollowByUser.getNoOfConnections();
        FollowByUser.setNoOfConnections(connection + 1);
        userRepository.save(FollowByUser);
        // returning the same connection data
        return connections;
    }


}
