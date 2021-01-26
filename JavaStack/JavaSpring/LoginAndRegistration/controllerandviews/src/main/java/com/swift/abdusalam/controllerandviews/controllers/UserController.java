package com.swift.abdusalam.controllerandviews.controllers;

import com.swift.abdusalam.controllerandviews.models.User;
import com.swift.abdusalam.controllerandviews.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        if(result.hasErrors()){
            return "registrationPage.jsp";
        }
        else {
            User user1 = userService.registerUser(user);
            session.setAttribute("userId", user1.getId());
            return "redirect:/home";
        }
    }
    @RequestMapping("/login")
    public String login(HttpSession session) {
        if(session.getAttribute("userId")!=null){
            return "redirect:/home";
        }
        return "loginPage.jsp";
    }
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session,Model model) {
        if(userService.authenticateUser(email,password)){
            User user = userService.findByEmail(email);
            session.setAttribute("userId",user.getId());
            return "redirect:/home";
        }
        else{
            model.addAttribute("error","Wrong Password");
            return "loginPage.jsp";
        }
    }
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        if(session.getAttribute("userId")==null){
            return "redirect:/login";
        }
        else {
            User user = userService.findUserById((Long) session.getAttribute("userId"));
            model.addAttribute("user",user);
            return "homePage.jsp";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}