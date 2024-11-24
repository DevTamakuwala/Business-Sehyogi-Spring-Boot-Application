package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.DTO.loginDTO;
import com.businesssehyogi.BusinessSehyogi.Repository.InvestorRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.UserRepository;
import com.businesssehyogi.BusinessSehyogi.Service.sendEmail;
import com.businesssehyogi.BusinessSehyogi.Service.sendSMS;
import com.businesssehyogi.BusinessSehyogi.model.Investor;
import com.businesssehyogi.BusinessSehyogi.model.User;
import com.businesssehyogi.BusinessSehyogi.wrapper.UserInvestorWrapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class UserController {

    @Autowired
    UserRepository repo;
    @Autowired
    sendEmail sendMail;
    @Autowired
    sendSMS sms;
    @Autowired
    InvestorRepository investorRepo;

    private int generateOtp() {
        return (int) (Math.random() * 100000);
    }

//    @GetMapping("/Csrf-Token")
//    public CsrfToken generateCSRF(HttpServletRequest httpServletRequest){
//        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
//    }

    //get All users
    @GetMapping("/getUsers")
    public List<User> getAllUser() {
        return repo.findAll();
    }

    //get one user
    @GetMapping("/getUser/{email}")
    public User getUser(@Valid @PathVariable("email") String email) {
        return repo.findByEmail(email);
    }

    //Login
    @GetMapping("/login/{email}")
    public loginDTO getUserForLogin(@Valid @PathVariable("email") String email) {
        return repo.login(email);
    }

    //Register user
    @PostMapping(value = "/registerUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@Valid @RequestBody User user) {
        if (user.getDateOfBirth() != null) {
            LocalDate dateOfBirth = LocalDate.parse(user.getDateOfBirth().toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            user.setDateOfBirth(dateOfBirth);
        } else {
            user.setDateOfBirth(null);
        }
        user.setDateTimeOfRegistration(LocalDateTime.now());
        repo.save(user);
        sendMail.sendMail(user.getEmail(), "Thank you for joining with Business Sehyogi", "Welcome, " + user.getFirstName() + user.getFirstName() + " to Business Sehyogi family. An amazing platform to share your ideas and find potential co-founders as well as investors on a single platform.\nTeam Business Sehyogi");
        return repo.findByEmail(user.getEmail());
    }

    //Register Investor
    @PostMapping(value = "/registerInvestor", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Investor addInvestor(@Valid @RequestBody UserInvestorWrapper userInvestorWrapper) {
        if (userInvestorWrapper.getUser().getDateOfBirth() != null) {
            LocalDate dateOfBirth = LocalDate.parse(userInvestorWrapper.getUser().getDateOfBirth().toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            userInvestorWrapper.getUser().setDateOfBirth(dateOfBirth);
        }
        System.out.println(userInvestorWrapper.getUser());
        repo.save(userInvestorWrapper.getUser());
        User user1 = repo.findByEmail(userInvestorWrapper.getUser().getEmail());
        userInvestorWrapper.getInvestor().setUserId(user1);
        sendMail.sendMail(userInvestorWrapper.getUser().getEmail(), "Thank you for joining with Business Sehyogi", "Welcome, " + userInvestorWrapper.getUser().getFirstName() + userInvestorWrapper.getUser().getFirstName() + "Our team contact you soon for completing the on boarding process.\nFor any queries related to the platform or on boarding process feel free to contact us by replying on this mail.\nTeam Business Sehyogi");
        return investorRepo.save(userInvestorWrapper.getInvestor());
    }

    //Send mail
    @GetMapping("/sendMail/{userId}")
    public int sendMail(@PathVariable("userId") int userId) {
        User user = repo.findById(userId).orElse(new User());
        int OTP = generateOtp();
        if (!user.getEmail().isEmpty()) {
            sendMail.sendMail(user.getEmail(), user.getFirstName() + ", Here is your OTP", "Hello " + user.getFirstName() + "\nPlease enter: " + OTP + " OTP to change your email address.");
        }
        return OTP;
    }

    //Verify contact
    @GetMapping("/verifyContact/{userId}")
    public void verifyContact(@PathVariable("userId") int userId) {
        User user = repo.findById(userId).orElse(new User());
        user.setContactNoVerified(true);
        repo.save(user);
    }

    //Verify email
    @GetMapping("/verifyEmail/{userId}")
    public void verifyEmail(@PathVariable("userId") int userId) {
        User user = repo.findById(userId).orElse(new User());
        user.setEmailVerified(true);
        repo.save(user);
    }

    //Send SMS
    @GetMapping("/sendSMS/{userId}")
    public String sendSMS(@PathVariable("userId") int userId) {
        User user = repo.findById(userId).orElse(new User());
        int OTP = generateOtp();
        String contactNo = "+91" + user.getContactNo();
        System.out.println("contactNo " + contactNo);
        if (user.getContactNo() != null) {
            sms.sendSms(contactNo, "Your OTP is: " + OTP);
            return String.valueOf(OTP);
        } else {
            return "Contact number is not available";
        }
    }

    //Update email
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

    //Update user
    @PostMapping(value = "/updateUser/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@Valid @RequestBody User newUserData, @PathVariable("userId") int userId) {
        User findUser = repo.findById(userId).orElse(new User());
        BigInteger newContactNo;
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

    @PostMapping("/updateUserPhoto/{userId}")
    public User updateUserPhoto(@Valid @RequestBody String photo, @PathVariable("userId") int userId) {
        User findUser = repo.findById(userId).orElse(new User());
        findUser.setPhoto(photo);
        User updateUser = repo.save(findUser);
        return ResponseEntity.ok(updateUser).getBody();
    }

    //get Current date and time
    @GetMapping("/getCurrentDateTime")
    public String getCurrentDateAndTime() {
        return LocalDateTime.now().toString();
    }

    //Check email
    @GetMapping("/checkEmail/{email}")
    public String isUsernameAvailable(@Valid @PathVariable("email") String user) {
        String var;
        if (repo.existsByEmailIgnoreCase(user)) {
            var = "true";
        } else {
            var = "false";
        }
        return var;
    }
}
