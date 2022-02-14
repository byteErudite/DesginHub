package com.vaibhav.design.LoLeD.BeverageMachine.entities.coffee;

import com.vaibhav.design.LoLeD.BeverageMachine.constants.BeverageTemperature;
import com.vaibhav.design.LoLeD.BeverageMachine.constants.Ingridient;
import com.vaibhav.design.LoLeD.BeverageMachine.entities.Beverage;

import static com.vaibhav.design.LoLeD.BeverageMachine.constants.Constants.COFFEE;

abstract class Coffee extends Beverage {

    Coffee() {
        super.setBeverageName(COFFEE);
        super.setBeverageTemperature(BeverageTemperature.HOT);
    }


}
