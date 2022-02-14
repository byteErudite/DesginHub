package com.vaibhav.design.LoLeD.BeverageMachine.entities;

import com.vaibhav.design.LoLeD.BeverageMachine.constants.BeverageSubType;
import com.vaibhav.design.LoLeD.BeverageMachine.constants.BeverageType;

public class Selection {
    private BeverageType beverageType;
    private BeverageSubType beverageSubType;

    public Selection(BeverageType beverageType, BeverageSubType beverageSubType) {
        this.beverageType = beverageType;
        this.beverageSubType = beverageSubType;
    }

    public BeverageType getBeverageType() {
        return beverageType;
    }

    public void setBeverageType(BeverageType beverageType) {
        this.beverageType = beverageType;
    }

    public BeverageSubType getBeverageSubType() {
        return beverageSubType;
    }

    public void setBeverageSubType(BeverageSubType beverageSubType) {
        this.beverageSubType = beverageSubType;
    }
}
