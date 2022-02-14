package com.vaibhav.design.LoLeD.BeverageMachine.behaviours;

import com.vaibhav.design.LoLeD.BeverageMachine.constants.TemperatureUnit;
import com.vaibhav.design.LoLeD.BeverageMachine.entities.Beverage;

import java.util.Objects;

public class ModulateTemperatureImpl implements ModulateTemperature{
    @Override
    public void moveTemperatureTo(Beverage beverage, int temp, TemperatureUnit tempUnit) {
        if (Objects.isNull(beverage)) {
            return;
        }
       // int currentTemperature = beverage.getBeverageTemperature();
    }
}
