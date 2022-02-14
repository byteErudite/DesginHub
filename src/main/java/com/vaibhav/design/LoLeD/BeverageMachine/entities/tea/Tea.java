package com.vaibhav.design.LoLeD.BeverageMachine.entities.tea;

import com.vaibhav.design.LoLeD.BeverageMachine.constants.BeverageTemperature;
import com.vaibhav.design.LoLeD.BeverageMachine.entities.Beverage;

import static com.vaibhav.design.LoLeD.BeverageMachine.constants.Constants.TEA;

public abstract class Tea extends Beverage {

    Tea() {
        super.setBeverageName(TEA);
        super.setBeverageTemperature(BeverageTemperature.HOT);
    }

}
