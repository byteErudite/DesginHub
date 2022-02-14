package com.vaibhav.design.LoLeD.BeverageMachine.behaviours;

import com.vaibhav.design.LoLeD.BeverageMachine.constants.TemperatureUnit;
import com.vaibhav.design.LoLeD.BeverageMachine.entities.Beverage;

public interface ModulateTemperature {
    void moveTemperatureTo(Beverage beverage, int temp, TemperatureUnit tempUnit);
}
