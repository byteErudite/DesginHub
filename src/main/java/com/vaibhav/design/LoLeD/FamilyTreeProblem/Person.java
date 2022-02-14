package com.vaibhav.design.LoLeD.FamilyTreeProblem;

import java.sql.Timestamp;
import java.time.Instant;

public class Person {
    private String name;
    private Gender gender;
    private String fathersName;
    private String mothersName;
    private String spouse;
    private Timestamp additonTime;

    public Person(String name, Gender gender,String spouse, String fathersName, String mothersName) {
        this.name = name;
        this.gender = gender;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.spouse = spouse;
        this.additonTime = Timestamp.from(Instant.now());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }
}
