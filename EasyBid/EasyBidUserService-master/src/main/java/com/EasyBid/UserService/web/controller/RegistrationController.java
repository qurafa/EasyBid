package com.EasyBid.UserService.web.controller;

import com.EasyBid.UserService.service.UserService;
import com.EasyBid.UserService.web.dto.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDTO() {
        return new UserRegistrationDTO();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDTO userRegistrationDTO) {
        userService.save(userRegistrationDTO);
        return "redirect:/registration?success";
    }

/*    @RequestMapping("/http://localhost:8080/registerUser/{userName}/{password}/{name}/{dob}/{phone}/{address}")
    public String registerUserGet(@PathVariable("userName") String userName,
                               @PathVariable("password") String password,
                               @PathVariable("name") String name,
                               @PathVariable("dob") String dob,
                               @PathVariable("phone") String phone,
                               @PathVariable("address") String address) {
        User user = new User();
        LocalDate localDate = LocalDate.parse(dob);
        databaseID++;
        user.setId(databaseID);
        user.setUserID(userName);
        user.setPassword(password);
        user.setName(name);
        user.setDob(localDate);
        user.setPhoneNumber(phone);
        user.setAddress(address);
        userRepository.save(user);
        return "login";
    }*/
}
