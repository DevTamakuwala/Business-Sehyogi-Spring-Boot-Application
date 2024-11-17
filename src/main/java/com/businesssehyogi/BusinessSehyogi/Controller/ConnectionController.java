package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.ConnectionsRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.UserRepository;
import com.businesssehyogi.BusinessSehyogi.model.Connections;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // accept the connection request
    // hit this API when user accept the connection request
    @PutMapping("/acceptRequest/{connectionId}")
    public Connections acceptRequest(@PathVariable("connectionId") int connectionId) {
        Connections connections = connectionsRepository.findByConnectionId(connectionId);
        User FollowToUser = connections.getCoFounderOrInvestorUser();
        connections.setStatus("Accept");
        connectionsRepository.save(connections);
        var totalConnections = FollowToUser.getNoOfConnections();
        FollowToUser.setNoOfConnections(totalConnections + 1);
        userRepository.save(FollowToUser);
        return connections;
    }

    // reject the connection request
    // hit this API when user rejects the connection request
    @PutMapping("/rejectRequest/{connectionId}")
    public Connections rejectRequest(@PathVariable("connectionId") int connectionId) {
        Connections connections = connectionsRepository.findByConnectionId(connectionId);
        User FollowByUser = connections.getFounderUser();
        connectionsRepository.deleteById(connectionId);
        var totalConnections = FollowByUser.getNoOfConnections();
        FollowByUser.setNoOfConnections(totalConnections - 1);
        userRepository.save(FollowByUser);
        return connections;
    }

    // Delete the connection (de connect)
    // delete the connection on the request of any user
    @DeleteMapping("/deleteConnection/{connectionId}")
    public String deleteConnection(@PathVariable("connectionId") int connectionId) {
        if (connectionsRepository.existsById(connectionId)) {
            Connections connections = connectionsRepository.findByConnectionId(connectionId);
            if (connections.getStatus().equals("Accept")) {
                User FollowByUser = connections.getFounderUser();
                User FollowToUser = connections.getCoFounderOrInvestorUser();
                var totalConnections = FollowByUser.getNoOfConnections();
                FollowByUser.setNoOfConnections(totalConnections - 1);
                userRepository.save(FollowByUser);
                totalConnections = FollowToUser.getNoOfConnections();
                FollowToUser.setNoOfConnections(totalConnections - 1);
                userRepository.save(FollowToUser);
                connectionsRepository.deleteById(connectionId);
                return "Connection deleted successfully.";
            } else {
                User FollowByUser = connections.getFounderUser();
                var totalConnections = FollowByUser.getNoOfConnections();
                FollowByUser.setNoOfConnections(totalConnections - 1);
                userRepository.save(FollowByUser);
                connectionsRepository.deleteById(connectionId);
                return "Connection request deleted successfully.";
            }
        } else {
            return "Connection not found.";
        }
    }

    // get all connection of user by user ID
    @GetMapping("/getAllConnection/{userId}")
    public List<Connections> getAllConnections(@PathVariable("userId") int userId) {
        User user = userRepository.findByUserId(userId).orElse(null);
        return connectionsRepository.findByFounderUser(user);
    }
}
