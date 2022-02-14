package com.vaibhav.design.LoLeD.BeverageMachine.entities;

import com.vaibhav.design.LoLeD.BeverageMachine.constants.BeverageTemperature;
import com.vaibhav.design.LoLeD.BeverageMachine.constants.Ingridient;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public abstract class Beverage {
    String beverageName;
    String beverageType;
    String beverageSubType;
    Map<Ingridient,Integer> ingredients;
    BeverageTemperature beverageTemperature;
    Timestamp createdAt;

    public Beverage() {
        ingredients = new HashMap<>();
        createdAt = Timestamp.from(Instant.now());
    }

    public String getBeverageSubType() {
        return beverageSubType;
    }

    public void setBeverageSubType(String beverageSubType) {
        this.beverageSubType = beverageSubType;
    }

    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public String getBeverageType() {
        return beverageType;
    }

    public void setBeverageType(String beverageType) {
        this.beverageType = beverageType;
    }

    public Map<Ingridient, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Ingridient, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public BeverageTemperature getBeverageTemperature() {
        return beverageTemperature;
    }

    public void setBeverageTemperature(BeverageTemperature beverageTemperature) {
        this.beverageTemperature = beverageTemperature;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getInfo() {
        return new StringJoiner(", ", Beverage.class.getSimpleName() + "[", "]")
                .add("beverageName='" + beverageName + "'")
                .add("beverageType='" + beverageType + "'")
                .add("ingredients=" + ingredients.keySet().stream().map(String::valueOf).collect(Collectors.toList()))
                .add("beverageTemperature=" + beverageTemperature)
                .add("createdAt=" + createdAt)
                .toString();
    }
}
