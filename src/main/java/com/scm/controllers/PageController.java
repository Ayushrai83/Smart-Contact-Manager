package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
