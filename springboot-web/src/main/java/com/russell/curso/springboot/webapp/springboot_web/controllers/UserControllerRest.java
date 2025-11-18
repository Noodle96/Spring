package com.russell.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.russell.curso.springboot.webapp.springboot_web.models.User;
import com.russell.curso.springboot.webapp.springboot_web.models.dto.MedicineDto;
import com.russell.curso.springboot.webapp.springboot_web.models.dto.UserDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;

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
    public UserDto detailsDto() {
        User user = new User("Russell", "Mendozaa");
        UserDto userDto = new UserDto("User Details", user);
        return userDto;
    }

    // http://localhost:8080/api/details-map
    @GetMapping("/details-map")
    public Map<String, Object> detailsMap() {
        Map<String, Object> body = new HashMap<>();
        User user = new User("Russell", "Mendoza");
        body.put("title", "User Details");
        // body.put("name", "Russell");
        // body.put("lastname", "Mendoza");
        body.put("user", user);
        return body;
    }

    // http://localhost:8080/api/list
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<User> list() {
        User user1 = new User("Russell", "Mendoza");
        User user2 = new User("John", "Doe");
        User user3 = new User("Jane", "Smith");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }

    // Usaremos @RequestParam para recibir parametros por la URL
    // localhost:8080/api/params?medicineName=Aspirin
    @RequestMapping(path = "/params", method = RequestMethod.GET)
    public MedicineDto requestMethodName(@RequestParam(required = false) String medicineName) {
        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setName(medicineName);
        return medicineDto;
    }

    // Usaremos @RequestMapping para recibir parametros por la URL
    // localhost:8080/api/params-medicine?name=Aspirin&manufacturer=Bayer&price=9.99
    // Solo pasar datos primitivos por la URL como String, int, double, boolean
    @RequestMapping(path = "/params-medicine", method = RequestMethod.GET)
    public MedicineDto requestMethodMedicine(@RequestParam(required = false) String name,
            @RequestParam(required = false) String manufacturer,
            @RequestParam(required = false) Double price) {
        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setName(name);
        medicineDto.setManufacturer(manufacturer);
        medicineDto.setPrice(price);
        return medicineDto;
    }

    // Recibiremos parametros usando HTTP request
    // localhost:8080/api/params-request?name=Aspirin&manufacturer=Bayer&price=9.99
    @RequestMapping(path = "/params-request", method = RequestMethod.GET)
    public MedicineDto request(HttpServletRequest request) {
        String name = request.getParameter("name");
        String manufacturer = request.getParameter("manufacturer");
        String priceParam = request.getParameter("price");
        Double price = null;
        if (priceParam != null) {
            try {
                price = Double.parseDouble(priceParam);
            } catch (NumberFormatException e) {
                // Manejar el error de parseo si es necesario
            }
        }
        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setName(name);
        medicineDto.setManufacturer(manufacturer);
        medicineDto.setPrice(price);
        return medicineDto;
    }

}
