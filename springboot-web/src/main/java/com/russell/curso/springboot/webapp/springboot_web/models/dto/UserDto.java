package com.russell.curso.springboot.webapp.springboot_web.models.dto;

import com.russell.curso.springboot.webapp.springboot_web.models.User;

/*\documentation
    * UserDto is a Data Transfer Object (DTO) that encapsulates user-related data for transfer between different layers of the application.
    * 
    * <p>
    * The class contains two attributes: "title" (a String) and "user" (an instance of the {@link com.russell.curso.springboot.webapp.springboot_web.models.User} class).
    * </p>
    * 
    * <p>
    * The constructor initializes these attributes, and the class provides standard getter and setter methods for accessing and modifying them.
    * </p>
 */
public class UserDto {
    private String title;
    private User user;
    public UserDto(String title, User user) {
        this.title = title;
        this.user = user;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    

}
