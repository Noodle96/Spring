package com.russell.curso.springboot.webapp.springboot_web.models.dto;

public class CardDto {
    private String name;
    private String type;
    private Integer elixir;
    private Double damageTower;
    private Boolean isOld;

    public CardDto() {
    }

    public CardDto(String name, String type, Integer elixir, Double damageTower, Boolean isOld) {
        this.name = name;
        this.type = type;
        this.elixir = elixir;
        this.damageTower = damageTower;
        this.isOld = isOld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getElixir() {
        return elixir;
    }

    public void setElixir(Integer elixir) {
        this.elixir = elixir;
    }

    public Double getDamageTower() {
        return damageTower;
    }

    public void setDamageTower(Double damageTower) {
        this.damageTower = damageTower;
    }

    public Boolean getIsOld() {
        return isOld;
    }

    public void setIsOld(Boolean isOld) {
        this.isOld = isOld;
    }

}
