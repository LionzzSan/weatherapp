package com.lionzzsan.weatherapp.service;

import com.lionzzsan.weatherapp.dal.UserRepository;
import com.lionzzsan.weatherapp.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }


    public void setUserLocation(UUID userId, UUID locationId) throws UsernameNotFoundException {
        User user = repository.findById(userId).orElseThrow(() -> new UsernameNotFoundException(userId.toString()));
        user.setLocation(locationId);
        this.repository.save(user);
    }

    public void purgeUserLocation(User user) {
        user.setLocation(null);
        repository.save(user);
    }
}
