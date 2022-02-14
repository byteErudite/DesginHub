package com.vaibhav.design.LoLeD.BeverageMachine.entities.tea;

import com.vaibhav.design.LoLeD.BeverageMachine.constants.Ingridient;

import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static com.vaibhav.design.LoLeD.BeverageMachine.constants.Constants.GREEN_TEA;

public class GreenTea extends Tea {

    private GreenTea() {

    }
    public static GreenTea create(int teaBagsRequired, int waterInMl) {
        GreenTea greenTea = new GreenTea();
        greenTea.setBeverageSubType(GREEN_TEA);
        Map<Ingridient, Integer> ingredients = greenTea.getIngredients();
        ingredients.put(Ingridient.WATER, waterInMl);
        ingredients.put(Ingridient.TEA_BAG, teaBagsRequired);
        greenTea.setIngredients(ingredients);
        return greenTea;
    }

    @Override
    public String getInfo() {
        return new StringJoiner(", ", GreenTea.class.getSimpleName() + "[", "]")
                .add("BeverageType = " + super.getBeverageName())
                .add("BeverageSubType = " + super.getBeverageSubType())
                .add("BeverageTemperature = " + super.getBeverageTemperature())
                .add("CreatedAt = " + super.getCreatedAt())
                .add("Ingridients = " + super.getIngredients().keySet().stream().map(String::valueOf).collect(Collectors.toList()))
                .toString();
    }
}
