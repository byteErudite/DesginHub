package com.vaibhav.design.LoLeD.BeverageMachine.behaviours;



import com.vaibhav.design.LoLeD.BeverageMachine.constants.Ingridient;
import com.vaibhav.design.LoLeD.BeverageMachine.entities.Beverage;
import com.vaibhav.design.LoLeD.BeverageMachine.entities.Selection;
import com.vaibhav.design.LoLeD.BeverageMachine.entities.tea.GreenTea;
import com.vaibhav.design.LoLeD.BeverageMachine.entities.tea.LemonTea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BeverageMachineImpl implements BeverageMachine {

    Map<Ingridient, Integer> inventory = new HashMap<>();
    Beverage processingBeverage;

    @Override
    public void createBeverage(Selection selection) throws Exception {
        if (Objects.isNull(selection.getBeverageType())) {
            throw new Exception("Invalid type selected");
        }
        System.out.println("Started creation");
        switch (selection.getBeverageType()) {
            case TEA:
                switch (selection.getBeverageSubType()) {
                    case GREEN_TEA: processingBeverage = GreenTea.create(1, 10);
                        break;
                    case LEMON_TEA: processingBeverage =  LemonTea.create(1, 10);
                        break;
                }
            case COFFEE:
                switch (selection.getBeverageSubType()) {
                    case BLACK_COFFEE : processingBeverage =  GreenTea.create(1, 10);
                        break;
                }
        }
        if (Objects.isNull(processingBeverage)) {
            throw new Exception("Error in creating beverage plese try again...");
        }
        validateIngredientsOnInventory(processingBeverage);
        updateInventory(processingBeverage);
        System.out.println("Beverage "+processingBeverage.getBeverageName()+" is ready");
        System.out.println(processingBeverage.getInfo());
        processingBeverage = null;
    }

    @Override
    public void initializeMachine() {
        poplulateInventory();
    }

    @Override
    public void displayInventory() {
        inventory.forEach(((ingridient, amount) -> {
            System.out.println(ingridient+" : "+amount);
        }));
    }

    private void poplulateInventory() {
        Arrays.stream(Ingridient.values()).forEach(i-> {
            inventory.put(i, 100);
        });
    }

    private void updateInventory(Beverage beverage) {
        beverage.getIngredients().forEach((ingredient, amount) -> {
            if (inventory.containsKey(ingredient)) {
                inventory.put(ingredient, inventory.get(ingredient) - amount);
            }
        });
    }

    private void validateIngredientsOnInventory(Beverage beverage) throws Exception {
        List<Ingridient> inSufficientIngredients = new ArrayList<>();
        beverage.getIngredients().forEach((ingredient, amount) -> {
            if (!inventory.containsKey(ingredient) || inventory.get(ingredient) < amount) {
                inSufficientIngredients.add(ingredient);
            }
        });
        if (!inSufficientIngredients.isEmpty()) {
            throw new Exception("Ingredients are not present in adequate amount");
        }
    }
}
