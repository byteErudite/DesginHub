package com.vaibhav.design.LoLeD.FamilyTreeProblem;

import java.util.List;

public interface DaoService {
    void initializeFamilyTree(String founderMale, String founderFemale);
    void addChild(String motherName, String childName, Gender gender) throws Exception;
    Person findPersonByName(String name);
    Person findMotherByChildName(String personName) throws Exception;
    List<Person> getSiblingsByMother(String motherName);
    List<Person> getSiblingsByFather(String fatherName);
}
