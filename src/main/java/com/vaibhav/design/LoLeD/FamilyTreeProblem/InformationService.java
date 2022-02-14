package com.vaibhav.design.LoLeD.FamilyTreeProblem;

import java.util.List;

public interface InformationService {
    void initialiseDynasty(String maleFounderName, String femaleFounderName);
    void addChild(String mothersName, String childName, Gender gender) throws Exception;
    List<Person> getRelatedPerson(String personName, RelationShip relationShip) throws Exception;
}
