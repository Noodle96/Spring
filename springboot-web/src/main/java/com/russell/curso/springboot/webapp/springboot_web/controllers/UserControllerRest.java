package com.russell.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.russell.curso.springboot.webapp.springboot_web.models.User;
import com.russell.curso.springboot.webapp.springboot_web.models.dto.CardDto;
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

    @Value("${me.card.name}")
    private String name;

    @Value("${me.card.type}")
    private String type;

    @Value("${me.card.elixir}")
    private Integer elixir;

    // @Value("${me.card.damageTower}")
    // private Double damageTower;

    @Value("${me.card.isOld}")
    private Boolean isOld;

    @Value("${me.card.counter}")
    private String[] counter;

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

    // Recibiremos parametros usando PathVariable
    // localhost:8080/api/path-variable/Princesa
    @RequestMapping(path = "path-variable/{name}", method = RequestMethod.GET)
    public CardDto requestPathVariable(@PathVariable String name) {
        CardDto cardDto = new CardDto();
        cardDto.setName(name);
        return cardDto;
    }

    // Recibiremos multiples parametros usando PathVariable
    // localhost:8080/api/multiple-path-variables/Princesa/Legendaria/3/150.5/true
    @RequestMapping(path = "/multiple-path-variables/{name}/{type}/{elixir}/{damageTower}/{isOld}", method = RequestMethod.GET)
    public CardDto requestMultiPathVariable(@PathVariable String name,
            @PathVariable String type,
            @PathVariable Integer elixir,
            @PathVariable Double damageTower,
            @PathVariable Boolean isOld) {
        CardDto cardDto = new CardDto();
        cardDto.setName(name);
        cardDto.setType(type);
        cardDto.setElixir(elixir);
        cardDto.setDamageTower(damageTower);
        cardDto.setIsOld(isOld);
        return cardDto;
    }

    // Uso de POST
    // localhost:8080/api/create
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        // Hacer algo con el usuario recibido, como guardarlo en la base de datos
        return user;
    }

    // Inyectar valores usando la anotacion @Value
    // localhost:8080/api/default-values
    @RequestMapping(path = "/default-values", method = RequestMethod.GET)
    public Map<String, Object> defaultValues(@Value("${me.card.damageTower}") Double damageTower) {
        Map<String, Object> json = new HashMap<>();
        json.put("name", name);
        json.put("type", type);
        json.put("elixir", elixir);
        json.put("damageTower", damageTower);
        json.put("isOld", isOld);
        json.put("counter", counter);
        return json;
    }

}
