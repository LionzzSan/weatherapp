package com.lionzzsan.weatherapp.dal;

import com.lionzzsan.weatherapp.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface UserRepository extends PagingAndSortingRepository<User, UUID> {

    User findByUsername(String username);

}
