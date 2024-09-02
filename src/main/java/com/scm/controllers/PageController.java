package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home page handler");

        //Sending data to view
        model.addAttribute("name", "Substring Technologies");
        model.addAttribute("linkdin", "https://in.linkedin.com/in/ayush-rai-gurukul-developer");
        model.addAttribute("github", "https://github.com/Ayushrai83");

        return "home";
    }

    //about route

    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("About Page LOading");
        return "about";
    }
    

    //services route

    @RequestMapping("/services")
    public String requestMethodName() {
        System.out.println("Services Page loading");
        return "services";
    }

    // contact page

    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }

    //Login

    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

    //Register

    @GetMapping("/register")
    public String register() {
        return new String("register");
    }


    
}
