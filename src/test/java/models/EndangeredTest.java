package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {
    @Test
    public void endangered_instantiatesCorrectly_true() throws Exception {
        Endangered endangered = new  Endangered("rhino","newborn","healthy");
        assertEquals(true,  endangered instanceof Endangered);
    }
    @Test
    public void endangeredAnimalsContainsAllEndangered_true() {
        Endangered endangered = new  Endangered("rhino","newborn","healthy");
        Endangered otherEndangered = new  Endangered("rhino", "newborn","healthy");
        assertTrue( Endangered.addAll().contains( endangered));
        assertTrue( Endangered.getAll().contains(otherEndangered));
    }
}