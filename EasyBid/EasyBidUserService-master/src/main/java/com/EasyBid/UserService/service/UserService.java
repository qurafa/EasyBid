package com.EasyBid.UserService.service;

import com.EasyBid.UserService.model.User;
import com.EasyBid.UserService.web.dto.UserRegistrationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
/*import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;*/

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDTO userRegistrationDTO);

}


/*@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final static String NOT_FOUND_MESSAGE = "User with email %s not found";
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format(NOT_FOUND_MESSAGE,email)));
    }

    public void signUpUser(UserRegistrationDTO userRegistrationDTO) {

        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();

        if (userExists) {
            throw new IllegalStateException("This email is already under user.");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);

    }

}*/
