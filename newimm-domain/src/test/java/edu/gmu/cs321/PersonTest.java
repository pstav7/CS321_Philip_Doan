package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testPersonCreation() {
        person person = new person("1", "John", "Doe");
        assertEquals("1", person.getId());
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
    }

    @Test
    public void testSetters() {
        person person = new person("1", "John", "Doe");
        person.setFirstName("Jane");
        person.setLastName("Smith");
        person.setId("2");

        assertEquals("Jane", person.getFirstName());
        assertEquals("Smith", person.getLastName());
        assertEquals("2", person.getId());
    }
}
