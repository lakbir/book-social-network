package com.lakbir.book.security;

import com.lakbir.book.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * lakbir.abderrahim - 17/07/2024
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
