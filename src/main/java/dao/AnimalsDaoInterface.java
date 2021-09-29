package dao;

import models.Animal;

public interface AnimalsDaoInterface {
     void add(Animal animal);
     Animal findAll();
     Animal findById(int id);
     void update(int id,String name,String age);
     void deleteAll();
     void deleteById(int id);
}
