package com.kayafirat.service;

import com.kayafirat.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends UserDetailsService {

    User addUser(User user);

    void deleteUser(long id);

    User updateUser(User user);

    Optional<User> getUser(long id);

    User getUser(String emailAddress);

    List<User> getAllUser();

}
