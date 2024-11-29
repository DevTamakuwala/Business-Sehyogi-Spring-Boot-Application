package com.businesssehyogi.BusinessSehyogi.Service;

import com.businesssehyogi.BusinessSehyogi.Repository.UserRepository;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAvailableUsers(int currentUserId) {
        return userRepository.findAvailableUsers(currentUserId);
    }
}
