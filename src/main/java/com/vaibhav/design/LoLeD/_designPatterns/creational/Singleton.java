package com.vaibhav.design.LoLeD._designPatterns.creational;

import java.util.Objects;

public class Singleton {
    public static void main(String[] args) {
        System.out.println("Created s1 instance....");
        SingletonImpl s1 = SingletonImpl.getInstance();
        System.out.println("Created s2 instance....");
        SingletonImpl s2 = SingletonImpl.getInstance();
        System.out.println("Equality check on s1 and s2 : "+(s1 == s2));
    }


}

class SingletonImpl {
    private static String resource;
    private static SingletonImpl instance;

    private SingletonImpl() {
    }

    public static SingletonImpl  getInstance() {
        if (Objects.isNull(instance)) {
            System.out.println("Created new instance");
            instance = new SingletonImpl();
            resource = "Instantiated";
        }
        return instance;
    }

    public static String getResource() {
        return resource;
    }

    public static void setResource(String resource) {
        SingletonImpl.resource = resource;
    }
}
