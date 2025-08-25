package com.russell.curso.springboot.webapp.springboot_web.models;

public class User {
    private String name;
    private String lastname;
    
    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name+"_TEST";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname+"_TEST";
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
}
