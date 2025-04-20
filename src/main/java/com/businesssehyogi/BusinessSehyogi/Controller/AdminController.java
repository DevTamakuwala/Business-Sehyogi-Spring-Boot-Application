package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.AdminRepository;
import com.businesssehyogi.BusinessSehyogi.model.Admin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    //Login
    @GetMapping("/adminLogin")
    public boolean getUserForLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
        Admin admin = adminRepository.findByAdminEmail(email);
        if (admin != null) {
            // Check if the entered password matches the stored password
            return passwordEncoder.matches(password, admin.getPassword());
        }
        return true;
    }

    @GetMapping("/getAdmin/{email}")
    public Admin getAdmin(@Valid @PathVariable("email") String email) {
        return adminRepository.findByAdminEmail(email);
    }

}
