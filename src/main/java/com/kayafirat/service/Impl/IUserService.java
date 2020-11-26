package com.kayafirat.service.Impl;

import com.kayafirat.entity.User;
import com.kayafirat.exceptions.UserAlreadyExistsException;
import com.kayafirat.repository.UserRepository;
import com.kayafirat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IUserService implements UserService {

    @Autowired
    UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public IUserService(){
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A,10);
    }

    @Override
    public User addUser(User _user) {
        _user.setRole("ROLE_USER");
        if(userRepository.findByEmailAddress(_user.getEmailAddress())!=null)
            throw new UserAlreadyExistsException(_user.getEmailAddress());

        return userRepository.save(_user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User getUser(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    @Override
    public org.springframework.security.core.userdetails.User loadUserByUsername(String emailAddress) {
        User user = userRepository.findByEmailAddress(emailAddress);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

        return authenticateUser(user,grantedAuthorities);
    }

    private org.springframework.security.core.userdetails.User authenticateUser(User user, List<GrantedAuthority> grantedAuthority){
        return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), bCryptPasswordEncoder.encode(user.getPassword()),grantedAuthority);
    }

}
