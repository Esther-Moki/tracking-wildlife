package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void animal_instantiatesCorrectly_true() throws Exception {
            Animal animal = new Animal("lion","newborn");
            assertEquals(true, animal instanceof Animal);
        }
    @Test
    public void AllAnimalsContainsAllAnimals_true() {
        Animal animal = new Animal("lion", "newborn");
        Animal otherAnimal = new Animal("lion", "newborn");
        assertTrue(Animal.getAll().contains(animal));
        assertTrue(Animal.getAll().contains(otherAnimal));
    }
//    @Test
//    public void getName_rangerInstantiatesWithName_Esther() {
//        Ranger ranger = new Ranger("Esther","badge");
//        assertEquals("Esther", ranger.getName());
//    }
//
//    @Test
//    public void getLocation_personInstantiatesWithLocation_String() {
//        Ranger ranger = new Ranger("Esther","badge");
//        assertEquals("location", ranger.getBadge());
//    }


}