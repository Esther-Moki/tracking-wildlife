package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {
    @Test
    public void sighting_instantiatesCorrectly_true() throws Exception {
        Sighting sighting = new Sighting("endangered","river banks","moki");
        assertEquals(true, sighting instanceof Sighting);
    }
    @Test
    public void AllSightinsContainsAllSightings_true() {
        Sighting sighting = new Sighting("endangered","river banks","moki");
        Sighting otherSighting = new Sighting("endangered", "riverbanks","moki");
        assertTrue(Sighting.findAll().contains(sighting));
        assertTrue(Sighting.findAll().contains(otherSighting));
    }

}