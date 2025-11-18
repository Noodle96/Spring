package com.russell.curso.springboot.webapp.springboot_web.models.dto;

public class MedicineDto {
    private String name;
    private String manufacturer;
    private Double price;

    public MedicineDto() {
    }

    public MedicineDto(String name, String manufacturer, Double price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
