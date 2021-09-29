package dao;

import models.Animal;
import models.Sighting;

public interface SightingsDaoInterface {
    //add
    void add(Sighting sighting);

    //read
    Sighting findAll();
    Sighting findById(int id);
    //update
    void update(int id,String type,String location,String ranger);

    //delete
    void deleteAll();
    void deleteById(int id);
}
