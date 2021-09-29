package models;

import java.util.ArrayList;

public class Sighting {
    public String type;
    public String location;
    public String ranger;
    private int id;

    public static ArrayList<Sighting> instance = new ArrayList<>();

    public Sighting(String type,String location,String ranger) {
        this.type = type;
        this.location =location;
        this.ranger = ranger;
        instance.add(this);
    }

    public String getType(String type) {

        return type;
    }
    public String getLocation(String location) {

        return location;
    }
    public static ArrayList<Sighting> findAll(){

        return instance;
    }

    public int setId(int id) {
        return id;
    }
}
