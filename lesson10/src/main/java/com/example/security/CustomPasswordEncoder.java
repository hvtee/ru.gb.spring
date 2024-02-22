//package com.example.security;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class CustomPasswordEncoder implements PasswordEncoder {
//    @Override
//    public String encode(CharSequence rawPassword) {
//        return (String) rawPassword;
//    }
//
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        return rawPassword.equals(encodedPassword);
//    }
//}
