//package com.example.security;
//
//import com.example.models.User;
//import com.example.repositories.UserRepository;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.List;
//
//public class CustomUserDetailsService implements UserDetailsService {
//    private final UserRepository userRepository;
//
//    public CustomUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByName(username)
//                .orElseThrow(() -> new UsernameNotFoundException(username));
//        return (UserDetails) new User(user.getName(), user.getPassword(), List.of(
//                new SimpleGrantedAuthority(user.getRole())
//        ));
//    }
//}
