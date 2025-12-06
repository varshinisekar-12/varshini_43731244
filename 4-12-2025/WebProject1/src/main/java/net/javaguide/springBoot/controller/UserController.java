package net.javaguide.springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import net.javaguide.springBoot.entity.User;
import net.javaguide.springBoot.service.UsersService;

@Controller
public class UserController {

    @Autowired
    private UsersService userService;

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    
    }
}
