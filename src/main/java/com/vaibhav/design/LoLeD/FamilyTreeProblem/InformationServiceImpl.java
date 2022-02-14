package com.vaibhav.design.LoLeD.FamilyTreeProblem;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.vaibhav.design.LoLeD.FamilyTreeProblem.Gender.FEMALE;
import static com.vaibhav.design.LoLeD.FamilyTreeProblem.Gender.MALE;
import static com.vaibhav.design.LoLeD.FamilyTreeProblem.ParentSide.MATERNAL;
import static com.vaibhav.design.LoLeD.FamilyTreeProblem.ParentSide.PATERNAL;

public class InformationServiceImpl implements InformationService {
    DaoService daoService = new DaoServiceImpl();

    @Override
    public void initialiseDynasty(String maleFounderName, String femaleFounderName) {
        daoService.initializeFamilyTree(maleFounderName, femaleFounderName);
    }

    @Override
    public void addChild(String mothersName, String childName, Gender gender) throws Exception {
        daoService.addChild(mothersName, childName, gender);
    }

    @Override
    public List<Person> getRelatedPerson(String personName, RelationShip relationShip) throws Exception {
        switch (relationShip) {
            case SON: return findChild(personName, MALE);
            case DAUGHTER: return findChild(personName, FEMALE);
            case PATERNAL_UNCLE: return findFathersSibling(personName, PATERNAL, MALE);
            case PATERNAL_AUNT: return findFathersSibling(personName, PATERNAL, FEMALE);
            case MATERNAL_UNCLE: return findFathersSibling(personName, MATERNAL, MALE);
            case MATERNAL_AUNT: return findFathersSibling(personName, MATERNAL, FEMALE);
            case SIBLINGS: return findSiblings(personName, null);
            case SISTER_IN_LAW: return findSiblingInLaw(personName, FEMALE);
            case BROTHER_IN_LAW: return findSiblingInLaw(personName, MALE);
            default: return Collections.emptyList();
        }
    }

    private List<Person> findSiblings(String personName, Gender gender) {
        Person person = daoService.findPersonByName(personName);
        List<Person> siblings = daoService.getSiblingsByFather(person.getFathersName());
        if (Objects.isNull(gender)) {
            return siblings;
        }
        return siblings.stream().filter(p -> gender.equals(p.getGender()))
                .collect(Collectors.toList());
    }

    private List<Person> findSiblingInLaw(String personName, Gender gender) {
        Person person = daoService.findPersonByName(personName);
        return findSiblings(person.getSpouse(), gender);
    }

    private List<Person> findFathersSibling(String personName, ParentSide uncleType, Gender gender) {
        Person person = daoService.findPersonByName(personName);
        String parentName = PATERNAL.equals(uncleType) ? person.getFathersName() : person.getMothersName();
        List<Person> parentsSiblings = daoService.getSiblingsByFather(parentName);
        return parentsSiblings.stream().filter(p -> gender.equals(p.getGender())).collect(Collectors.toList());
    }

    private List<Person> findChild(String parentName, Gender childGender) throws Exception {
        Person parent = daoService.findPersonByName(parentName);
        if (Objects.isNull(parent)) {
            throw new Exception("Person not found with name : "+parentName);
        }
        List<Person> siblings;
        if (MALE.equals(parent.getGender())) {
            siblings = daoService.getSiblingsByFather(parentName);
        } else {
            siblings =  daoService.getSiblingsByMother(parentName);
        }
        return siblings.stream().filter(p -> childGender.equals(p.getGender())).collect(Collectors.toList());
    }
}
