package models;

import java.util.ArrayList;

// endangered animal extends animal but with new attributes age and health

public class  Endangered extends Animal {

    private String health;
    private int id;
    public static ArrayList<Endangered> instance = new ArrayList<Endangered>();
    // constructor with animal attributes and new attributes for endangered animal
    public Endangered(String name,String age,String health) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.health = health;
        instance.add(this);
        this.id = instance.size();
    }

    //get methods for endangered animal
   public String getName(){
      return name;
   }
    public String getAge() {
        return age;
    }
    public String getHealth() {
        return health;
    }
    public int getId() {
        return id;
    }
    public static ArrayList<Endangered> addAll() {
        return instance;
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
    public void setId(int id) {
        this.id = instance.size();
    }


}