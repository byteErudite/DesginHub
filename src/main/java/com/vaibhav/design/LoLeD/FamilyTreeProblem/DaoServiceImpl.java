package com.vaibhav.design.LoLeD.FamilyTreeProblem;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class DaoServiceImpl implements DaoService {

    private Map<String, Person> familyMembersRecord = new HashMap<>();
    private String founder;

    @Override
    public void initializeFamilyTree(String founderMale, String founderFemale) {
        Person founder1 = new Person(founderMale, Gender.MALE, founderFemale, null, null);
        Person founder2 = new Person(founderFemale, Gender.FEMALE, founderMale, null, null);
        familyMembersRecord.put(founderMale, founder1);
        familyMembersRecord.put(founderFemale, founder2);
    }

    @Override
    public void addChild(String motherName, String childName, Gender gender) throws Exception {
        Person mother = familyMembersRecord.get(motherName);
        if (Objects.isNull(mother)) {
            throw new Exception(motherName + " does not exists in family tree");
        }
        Person child = new Person(childName, gender, null, mother.getSpouse(), motherName);
        familyMembersRecord.put(childName, child);
    }

    @Override
    public Person findMotherByChildName(String personName) throws Exception {
        Person person = familyMembersRecord.get(personName);
        if (Objects.isNull(person)) {
            throw new Exception(personName + " does not exists in family tree");
        }
        return familyMembersRecord.get(person.getMothersName());
    }

    @Override
    public List<Person> getSiblingsByMother(String motherName) {
        return familyMembersRecord.values().stream().filter(p -> p.getMothersName().equalsIgnoreCase(motherName)).collect(Collectors.toList());
    }

    @Override
    public List<Person> getSiblingsByFather(String fatherName) {
        if (familyMembersRecord.isEmpty()) {
            return Collections.emptyList();
        }
        return familyMembersRecord.values().stream().
                filter(p -> Objects.nonNull(p.getFathersName()) && p.getFathersName().equalsIgnoreCase(fatherName)).
                collect(Collectors.toList());
    }

    @Override
    public Person findPersonByName(String name) {
        return familyMembersRecord.get(name);
    }
}
