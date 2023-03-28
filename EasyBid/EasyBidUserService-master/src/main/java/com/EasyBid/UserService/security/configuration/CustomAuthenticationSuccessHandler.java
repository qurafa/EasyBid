package com.EasyBid.UserService.security.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static CustomAuthenticationSuccessHandler instance = new CustomAuthenticationSuccessHandler();

    private CustomAuthenticationSuccessHandler(){}

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        response.sendRedirect("http://localhost:3000/1");
    }

    public static CustomAuthenticationSuccessHandler getInstance() {
        return instance;
    }
}