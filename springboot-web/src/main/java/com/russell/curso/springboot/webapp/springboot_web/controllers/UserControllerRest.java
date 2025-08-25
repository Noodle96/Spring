package com.russell.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*documentation
    * UserControllerRest is a Spring REST controller that handles HTTP requests related to user details.
    * 
    * <p>
    * The class is annotated with {@link org.springframework.web.bind.annotation.RestController}, which marks it as a RESTful web controller
    * capable of handling web requests in a Spring Boot application and returning data directly in the response body.
    * </p>
    * 
    * <p>
    * The {@code details} method is mapped to the "/details2" URL using the {@link org.springframework.web.bind.annotation.GetMapping} annotation.
    * This means that when a GET request is made to "/details2", this method will be invoked.
    * </p>
    * 
    * <p>
    * The method returns a {@link java.util.Map} containing user-related attributes ("title", "name", "lastname"),
    * which will be automatically converted to JSON format and sent in the HTTP response body.
 * </p>
 */

@RestController
@RequestMapping("/api") // Base path for all endpoints in this controller
public class UserControllerRest {
    // http://localhost:8080/api/details
    @GetMapping("/details")
    public Map<String, Object> details() {
        Map<String, Object> body = new HashMap<>();
        body.put("title", "User Details");
        body.put("name", "Russell");
        body.put("lastname", "Mendoza");
        return body;
    }
}
