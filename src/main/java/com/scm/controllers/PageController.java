package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.services.UserService;


@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String register(Model model) {
        UserForm userForm = new UserForm();
        // userForm.setName("Ayush");
        // userForm.setAbout("This is about: Write something about you");
        model.addAttribute("userForm", userForm);

        return new String("register");
    }

    //Processing register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println("Processing registration");
        // fetch form data
        // UserForm
        System.out.println(userForm);

        // validate form data

        // save to database

        // userservice

        //UserForm --> User
        User user = User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phoneNumber(userForm.getPhoneNumber())
        .profilePic("https://thumbs.dreamstime.com/b/default-avatar-profile-icon-vector-social-media-user-image-182145777.jpg")
        .build();
        User savedUser = userService.saveUser(user);
        System.out.println("user saved :");
        
        // message = "Registration Successful"

        // add the message:
        return "redirect:/register";
    }
    
}
