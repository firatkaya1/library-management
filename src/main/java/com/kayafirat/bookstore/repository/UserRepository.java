package com.kayafirat.bookstore.repository;

import com.kayafirat.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmailAddress(String emailAddress);
}
