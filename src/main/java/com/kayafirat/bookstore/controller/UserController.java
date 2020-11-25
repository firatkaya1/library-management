package com.kayafirat.bookstore.controller;

import com.kayafirat.bookstore.entity.User;
import com.kayafirat.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users",userService.getAllUser());
        model.addAttribute("user", new User());
        return "users";
    }


}
