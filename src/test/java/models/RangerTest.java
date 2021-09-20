package models;

import models.Ranger;
import org.junit.Test;
import java.time.LocalDateTime;


import static org.junit.Assert.*;

public class RangerTest {
    @Test
    public void ranger_instantiatesCorrectly_true() throws Exception {
        Ranger ranger = new Ranger("Esther","badge");
        assertEquals(true, ranger instanceof Ranger);
    }

    @Test
    public void getName_rangerInstantiatesWithName_Esther() {
        Ranger ranger = new Ranger("Esther","badge");
        assertEquals("Esther", ranger.getName());
    }

    @Test
    public void getLocation_personInstantiatesWithLocation_String() {
        Ranger ranger = new Ranger("Esther","badge");
        assertEquals("location", ranger.getBadge());
    }
//    @Test
//    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception{
//        Ranger animalSighting = new sightingAnimal();
//        assertEquals(LocalDateTime.now().getDayOfWeek(),  animalSighting.getCreatedAt().getDayOfWeek());
//    }
//    public Ranger sightingAnimal(){
//        return new Ranger("Esther");
//    }
}