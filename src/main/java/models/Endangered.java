package models;

import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;

// endangered animal extends animal but with new attributes age and health

public class  Endangered extends AnimalsAbstract {

    private String health;
    private String age;

    // constructor with animal attributes and new attributes for endangered animal
    public Endangered(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
    }

    //get methods for endangered animal
    public String getName(){
        return name;
    }
    public String getHealth() {
        return health;
    }
    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(String health) {
        this.health = health;
    }
    //set method for endangered animals age
    public void setAge(String age) {
        this.age = age;
    }

    // overriding endangered animal
//    @Override
//    public boolean equals(Object otherEndangeredAnimal) {
//        if (otherEndangeredAnimal instanceof Endangered) {
//            Endangered newEndangeredAnimal = (Endangered) otherEndangeredAnimal;
//            return (this.getName().equals(newEndangeredAnimal.getName()));
//        }
//
//        return false;
    }