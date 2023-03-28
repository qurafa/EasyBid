package com.EasyBid.UserService.web.controller;

import com.EasyBid.UserService.model.User;
import com.EasyBid.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LogoutController {

    private UserRepository userRepository; // assuming UserRepository is your repository interface for user entity
    @Autowired
    public LogoutController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/logout")
    public String logout(String email) {
        // Find the user by userId and update the value in the database
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setIsEnabled(false);
            userRepository.save(user);
        }
        // Perform any other logout related tasks, such as clearing the session
        // Redirect the user to the login page
        return "redirect:/login";
    }

}
