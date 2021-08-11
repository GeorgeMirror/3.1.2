package com.mirror.springbootsite.controller;

import com.mirror.springbootsite.model.User;
import com.mirror.springbootsite.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@Log
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ModelAndView getPageUser(Principal principal) {
        ModelAndView mav = new ModelAndView("userPage");

        List<User> users = userService.getAllUsers();
        mav.addObject("users", users);

        User currentUser = (User) userService.loadUserByUsername(principal.getName());
        mav.addObject("currentUser", currentUser);

        return mav;
    }
}
