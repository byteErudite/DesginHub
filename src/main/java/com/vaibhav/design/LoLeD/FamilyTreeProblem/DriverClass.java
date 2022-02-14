package com.vaibhav.design.LoLeD.FamilyTreeProblem;

import java.util.stream.Collectors;

import static com.vaibhav.design.LoLeD.FamilyTreeProblem.Gender.MALE;
import static com.vaibhav.design.LoLeD.FamilyTreeProblem.RelationShip.SON;

public class DriverClass {
    InformationService informationService = new InformationServiceImpl();

    public static void main(String[] args) throws Exception {
        DriverClass d = new DriverClass();
        d.startService();
    }

    private void startService() throws Exception {
        informationService.initialiseDynasty("Shantanu", "Ganga");
        informationService.addChild("Ganga", "DevBrat", MALE);
        System.out.println("Shantanu's son's are : "+informationService.getRelatedPerson("Shantanu", SON).stream().map(Person::getName).collect(Collectors.toList()));
    }
}
