package com.vaibhav.design.LoLeD.BeverageMachine;

import com.vaibhav.design.LoLeD.BeverageMachine.behaviours.BeverageMachine;
import com.vaibhav.design.LoLeD.BeverageMachine.behaviours.BeverageMachineImpl;
import com.vaibhav.design.LoLeD.BeverageMachine.constants.BeverageSubType;
import com.vaibhav.design.LoLeD.BeverageMachine.constants.BeverageType;
import com.vaibhav.design.LoLeD.BeverageMachine.entities.Selection;

public class DriverClass {

    public static void main(String[] args) throws Exception {
        DriverClass d = new DriverClass();
        d.startMachine();
    }

    private void startMachine() throws Exception {
        System.out.println("Machine started");
        BeverageMachine machine = new BeverageMachineImpl();
        machine.initializeMachine();
        machine.displayInventory();
        machine.createBeverage(new Selection(BeverageType.TEA, BeverageSubType.GREEN_TEA));
        machine.displayInventory();
    }


}
