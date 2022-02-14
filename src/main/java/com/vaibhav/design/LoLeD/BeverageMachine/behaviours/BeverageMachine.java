package com.vaibhav.design.LoLeD.BeverageMachine.behaviours;

import com.vaibhav.design.LoLeD.BeverageMachine.constants.BeverageType;
import com.vaibhav.design.LoLeD.BeverageMachine.entities.Beverage;
import com.vaibhav.design.LoLeD.BeverageMachine.entities.Selection;

public interface BeverageMachine {
    void createBeverage(Selection selection) throws Exception;
    void initializeMachine();
    void displayInventory();

}
