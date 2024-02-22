//package com.example.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .authorizeHttpRequests(registry -> registry
//                        .requestMatchers("admins/**").hasAuthority("admin")
//                        .requestMatchers("forms/**").hasAuthority("admin")
//                        .requestMatchers("readers/**").hasAuthority("reader")
//                        .requestMatchers("books/**").permitAll()
//                        .anyRequest().permitAll()
//                )
//                .formLogin(Customizer.withDefaults())
//                .build();
//    }
//}
