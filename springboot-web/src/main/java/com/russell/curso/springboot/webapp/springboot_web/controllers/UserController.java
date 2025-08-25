package com.russell.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * UserController is a Spring MVC controller that handles HTTP requests related to user details.
 * 
 * <p>
 * The class is annotated with {@link org.springframework.stereotype.Controller}, which marks it as a web controller
 * capable of handling web requests in a Spring Boot application.
 * </p>
 * 
 * <p>
 * The {@code details} method is mapped to the "/details" URL using the {@link org.springframework.web.bind.annotation.GetMapping} annotation.
 * This means that when a GET request is made to "/details", this method will be invoked.
 * </p>
 * 
 * <p>
 * The method adds user-related attributes ("title", "name", "lastname") to the {@link org.springframework.ui.Model} object,
 * which makes them available to the view named "details".
 * </p>
 */
@Controller
public class UserController {
    
    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("title", "User Details");
        model.addAttribute("name", "Russell");
        model.addAttribute("lastname", "Mendoza");
        return "details"; 
    }

}