package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.DTO.loginDTO;
import com.businesssehyogi.BusinessSehyogi.Repository.UserRepo;
import com.businesssehyogi.BusinessSehyogi.Service.sendOTPEmail;
import com.businesssehyogi.BusinessSehyogi.Service.sendSMS;
import com.businesssehyogi.BusinessSehyogi.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserRepo repo;
    @Autowired
    sendOTPEmail sendMail;
    @Autowired
    sendSMS sms;

    private int generateOtp() {
        return (int) (Math.random() * 100000);
    }

    @GetMapping("/getUser")
    public List<User> getAllUser() {
        return repo.findAll();
    }

    @GetMapping("/login/{username}")
    public loginDTO getUser(@Valid @PathVariable("username") String username) {
        return repo.login(username);
    }

    @PostMapping(value = "/registerUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@Valid @RequestBody User user) {
        LocalDate dateOfBirth = LocalDate.parse(user.getDateOfBirth().toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        user.setDateOfBirth(dateOfBirth);
        repo.save(user);
        return user;
    }

    @GetMapping("/sendMail/{userId}")
    public int sendMail(@PathVariable("userId") int userId) {
        User user = repo.findById(userId).orElse(new User());
        int OTP = generateOtp();
        if (!user.getEmail().isEmpty()) {
            sendMail.sendMail(user.getEmail(), user.getFirstName() + ", Here is your OTP", "Hello " + user.getFirstName() + "\nPlease enter: " + OTP + " OTP to change your email address.");
        }
        return OTP;
    }

    @GetMapping("/verifyContact/{userId}")
    public void verifyContact(@PathVariable("userId") int userId) {
        User user = repo.findById(userId).orElse(new User());
        user.setContactNoVerified(true);
        repo.save(user);
    }

    @GetMapping("/verifyEmail/{userId}")
    public void verifyEmail(@PathVariable("userId") int userId) {
        User user = repo.findById(userId).orElse(new User());
        user.setEmailVerified(true);
        repo.save(user);
    }

    @GetMapping("/sendSMS/{userId}")
    public String sendSMS(@PathVariable("userId") int userId) {
        User user = repo.findById(userId).orElse(new User());
        int OTP = generateOtp();
        String contactNo = "+91" + user.getContactNo();
        if (user.getContactNo() != null) {
            sms.sendSms(contactNo, "Your OTP is: " + OTP);
            return String.valueOf(OTP);
        } else {
            return "Contact number is not available";
        }
    }

    @PostMapping("/updateEmail/{userId}")
    public String updateEmail(@PathVariable("userId") int userId, @RequestBody String newEmail) {
        User user = repo.findById(userId).orElse(new User());
        String oldMail = user.getEmail();
        if (newEmail == null) {
            return "Please enter email properly";
        } else {
            user.setEmail(newEmail);
            repo.save(user);
            sendMail.sendMail(oldMail, "Email Updated", "Your email has been updated to " + user.getEmail() + "\nIf you did not changed this mail please contact on businesssehyogi@gmail.com");
            sendMail.sendMail(user.getEmail(), "Email Updated", "Your email has been updated from " + oldMail + "\nIf you did not changed this mail please contact on businesssehyogi@gmail.com");
            return "Email updated successfully..!";
        }
    }

    @PostMapping(value = "/updateUser/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@Valid @RequestBody User newUserData, @PathVariable("userId") int userId) {
        User findUser = repo.findById(userId).orElse(new User());
        BigDecimal newContactNo;
        char newGender;
        String newFirstName, newLastName;
        if (newUserData.getContactNo() == null) {
            newContactNo = findUser.getContactNo();
        } else {
            newContactNo = newUserData.getContactNo();
        }
        if (newUserData.getGender() == '\u0000') {
            newGender = findUser.getGender();
        } else {
            newGender = newUserData.getGender();
        }
        if (newUserData.getFirstName() == null) {
            newFirstName = findUser.getFirstName();
        } else {
            newFirstName = newUserData.getFirstName();
        }
        if (newUserData.getLastName() == null) {
            newLastName = findUser.getLastName();
        } else {
            newLastName = newUserData.getLastName();
        }
        findUser.setContactNo(newContactNo);
        findUser.setGender(newGender);
        findUser.setLastName(newLastName);
        findUser.setFirstName(newFirstName);
        User updateUser = repo.save(findUser);
        return ResponseEntity.ok(updateUser).getBody();
    }

    @PostMapping("/checkUsername/{username}")
    public Boolean isUsernameAvailable(@Valid @PathVariable("username") String user) {
        return repo.existsByUserNameIgnoreCase(user);
    }

}
