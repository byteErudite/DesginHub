package com.vaibhav.design.LoLeD.BeverageMachine.entities.tea;

import com.vaibhav.design.LoLeD.BeverageMachine.constants.Ingridient;

import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static com.vaibhav.design.LoLeD.BeverageMachine.constants.Constants.LEMON_TEA;

public class LemonTea extends Tea {

    private LemonTea() {

    }
    public static LemonTea create(int teaBagsRequired, int lemonExtract) {
        LemonTea lemonTea = new LemonTea();
        lemonTea.setBeverageType(LEMON_TEA);
        Map<Ingridient, Integer> ingredients = lemonTea.getIngredients();
        ingredients.put(Ingridient.LEMON, lemonExtract);
        ingredients.put(Ingridient.TEA_BAG, teaBagsRequired);
        return lemonTea;
    }

    @Override
    public String getInfo() {
        return new StringJoiner(", ", GreenTea.class.getSimpleName() + "[", "]")
                .add("BeverageType = " + super.getBeverageName())
                .add("BeverageSubType = " + super.getBeverageSubType())
                .add("BeverageTemperature = " + super.getBeverageTemperature())
                .add("CreatedAt = " + super.getCreatedAt())
                .add("Ingredients = " + super.getIngredients().keySet().stream().map(String::valueOf).collect(Collectors.toList()))
                .toString();
    }

}
